/*
A top secret message containing uppercase letters from 'A' to 'Z' has been encoded as numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent and you need to determine the total number of ways that the message can be decoded.

Since the answer could be very large, take it modulo 109 + 7.

Example

For message = "123", the output should be

mapDecoding(message) = 3.

"123" can be decoded as "ABC" (1 2 3), "LC" (12 3) or "AW" (1 23), so the total number of ways is 3.
*/

int mapDecoding(String message) {
    if(message == null) return 0;
    if(message.length() == 0) return 1;
    int n = message.length();
    int mod = (int)Math.pow(10, 9) + 7;
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = message.charAt(0) != '0' ? 1 : 0;
    for(int i = 2; i <= n; i++) {
        int first = Integer.valueOf(message.substring(i-1, i));
        int second = Integer.valueOf(message.substring(i-2, i));
        if(first >= 1 && first <= 9) {
           dp[i] += dp[i-1];  
        }
        if(second >= 10 && second <= 26) {
            dp[i] += dp[i-2];
        }
        dp[i] = dp[i] % (int)(Math.pow(10, 9) + 7);
    }
    return dp[n];
}

