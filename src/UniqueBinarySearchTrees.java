//96 不同的二叉搜索树，输出个数
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int count = 0;
        for(int i = 3; i <= n; i++){
            count = 0;
            for(int j = 1; j <= i; j ++){
                if(i - count >=2) {
                    dp[i] += 2 * dp[i - j] * dp[j - 1];
                    count += 2;
                }else if(i - count == 1){
                    dp[i] += dp[i - j] * dp[j - 1];
                    count += 1;
                }else break;
            }
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
}
