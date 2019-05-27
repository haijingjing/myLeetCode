import java.util.Arrays;

//673 最长上升子序列的个数
public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int[] dp = new int[n];
        int[] count = new int[n];
        int max = Integer.MIN_VALUE, res = 0;
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }else if(nums[i] > nums[j] && dp[j] + 1 == dp[i]){
                    count[i] += count[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        for(int i = 0; i < n; i++){
            if(dp[i] == max){
                res += count[i];
            }
        }
        return res;
    }
}
