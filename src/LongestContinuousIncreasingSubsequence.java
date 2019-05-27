//674 最长连续上升子串
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        if(n == 0 || n == 1) return n;
        int[] dp = new int[n];

        dp[0] = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
