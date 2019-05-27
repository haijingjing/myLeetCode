import java.util.List;

//120. 三角形最小路径和
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        int n = triangle.size();//n层，第i层有i个数
        int[][] dp = new int [n][n];
        dp[0][0] = triangle.get(0).get(0);
        //从上往下加，会有边界条件的问题，从下往上则不会
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }else if(j == i){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(dp[n-1][i] < min){
                min = dp[n-1][i];
            }
        }
        return min;
    }

    //只需要记录一个，不需要记录行，反正最终返回最上面那个数
    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
