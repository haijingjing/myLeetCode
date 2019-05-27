//91 解码方式
public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <=n; i++){
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if(one >= 1 && one <= 9){
                dp[i] += dp[i-1];
            }
            if(two >= 10 && two <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
