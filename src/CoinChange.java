import java.util.Arrays;

//322. 零钱兑换
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int n = coins.length;
        if(n == 0) return -1;

        Arrays.sort(coins);
        if(amount < coins[0]) return -1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        for(int i = 0; i < n && coins[i] <= amount; i++) {
            dp[coins[i]] = 1;
        }


        for(int i = coins[0] + 1; i <= amount; i ++){
            for(int j = 0; j < n && i > coins[j]; j ++) {
                if (dp[i - coins[j]] != -1) {
                    if (dp[i] != -1) {
                        dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                    } else {
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
}
