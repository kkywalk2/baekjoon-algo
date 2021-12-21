package leetcode;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount + 1];

        for(int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) return -1;
        return (int)dp[amount];
    }
}
