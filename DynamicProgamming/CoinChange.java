/*You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/


/*Top-Down*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if( amount < 1) return 0;
        int[] cache = new int[amount + 1];
        return helper(coins, amount, cache);
    }
    
    private int helper(int[] coins, int rem, int[] cache) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (cache[rem] != 0) return cache[rem];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int tmp = helper(coins, rem - coins[i], cache);
            if (tmp >= 0 && tmp < min) {
                min = tmp + 1;
            }
        }
        cache[rem] = (min==Integer.MAX_VALUE) ? -1 : min;
        return cache[rem];
    }
}



/*Bottom-down*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if( amount < 1) return 0;
        int[] dp = new int[amount + 1];
		
		
    }
}










































