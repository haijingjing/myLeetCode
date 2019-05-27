//62 唯一路径
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i ++){
            dp[i][1] = 1;
        }
        for(int i = 1; i <= n; i ++){
            dp[1][i] = 1;
        }
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n ;j ++){
                if(i == 1 || j == 1) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    //优化dp方程 w[j] = w[j] + w[j-1](等于上一行的加上左边一位的位移)
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 2; j <= n ;j++){
                dp[j] += dp[j - 1];
            }
        }
        return dp[n];
    }
}
