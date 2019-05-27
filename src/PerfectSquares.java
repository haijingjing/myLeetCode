import java.util.Arrays;

//279 完全平方数
public class PerfectSquares {
    public int numSquares(int n) {
        int sqrt = (int)Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i = 1; i <= sqrt; i ++){
            dp[i * i] = 1;
        }
        for(int i = 2; i <= n; i ++){
            for(int j = 1; j * j  < i && j <= sqrt; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

//    public int sqrtX(int x){
//        double begin = 0, end = x;
//        double res = 1, mid = 1;
//        while (Math.abs(res - x) > 0.000001){
//            mid = (begin + end)/2;
//            res = mid * mid;
//            if(res > x){
//                end = mid;
//            }else {
//                begin = mid;
//            }
//        }
//        return (int)mid;
//    }
}
