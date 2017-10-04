/*
Implement a function that takes two strings, s and x, as arguments and finds the first occurrence of the string x in s. The function should return an integer indicating the index in s of the first occurrence of x. If there are no occurrences of x in s, return -1.

Example

For s = "CodefightsIsAwesome" and x = "IA", the output should be
strstr(s, x) = -1;
For s = "CodefightsIsAwesome" and x = "IsA", the output should be
strstr(s, x) = 10.
*/

//Implementation using Rabin-Karp
private class RollingHash {
    private final int b = 256;
    private final int p = 31;
    private int bpow = 0;
    private String str;
    private int size;
    private int hash;
    private int wStart = 0; //window start;
    public RollingHash(String s, int windowSize ) {
        str = s;
        size = windowSize;
        bpow = (int)Math.pow(b, size - 1 );
        hash = getInitHash();
    }
    private int getInitHash() {
        int hash = 0;
        for (int i = 0; i < size; i++)
        {
            hash = (b*hash + str.charAt(i)) % p;
        }   
        return hash;
    }
    public void moveWindow() {
       hash = ( b * (hash - str.charAt(wStart)*bpow) + str.charAt(wStart + size)) % p;
       if ( hash < 0)
           hash+= p;
        wStart++;
    }
    public int getHash() {
        return hash;
    }
}

int findFirstSubstringOccurrence(String s, String x) {
    if (s == null || s.isEmpty() || x == null || x.isEmpty() || 
        x.length() > s.length() || (s.length() == x.length() && !s.equals(x)) ) return -1;
    RollingHash xHash = new RollingHash(x, x.length());
    RollingHash sHash = new RollingHash(s, x.length());
    int j = 0;
    for (int i = 0; i <= s.length() - x.length(); i++) {
        if (xHash.getHash() == sHash.getHash()) {
            for (j = 0; j < x.length(); j++ ) {
                if (s.charAt(i + j) != x.charAt(j) ) {
                    break;
                }
                if (j == x.length() - 1) return i;
            }
        }
        if (i < s.length() - x.length()) {
            sHash.moveWindow();
        }
    }
    
    return -1;
}
