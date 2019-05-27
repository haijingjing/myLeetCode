//63 唯一路径2
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            }else {
                break;
            }
        }
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        dp[1][1] = obstacleGrid[0][0] != 1 ?  1 : 0;
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                dp[i][j] +=  obstacleGrid[i-1][j-1] != 1 ? dp[i][j-1] + dp[i-1][j] : 0;
            }
        }
        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }
}
