//300 最长上升子序列
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return len;
            }
            int[] dp = new int[len];
            // 自己一定是一个子序列
            Arrays.fill(dp, 1);
            for (int i = 1; i < len; i++) {
                // 看以前的，比它小的，说明可以接在后面形成一个更长的子序列
                // int curMax = Integer.MIN_VALUE; 不能这样写，万一前面没有比自己小的，
                // 这个值就得不到更新
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }

            int res = dp[0];
            for (int i = 0; i < len; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
    }
    public int lengthOfLISTwo(int[] nums) {
        /**
         dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
         由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
         对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
         1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
         数组尾部, 并将最长递增序列长度maxL加1
         2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
         **/
        int maxL = 0;
        int[] dp = new int[nums.length];
        for(int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = (lo + hi) >>> 1;
                if(dp[mid] < num)
                    lo = mid+1;
                else
                    hi = mid;
            }
            dp[lo] = num;
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }
}