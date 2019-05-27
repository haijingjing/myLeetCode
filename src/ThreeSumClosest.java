import java.util.Arrays;

//16 最接近的三数之和
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if(n < 3) return -1;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = min;
        int left = 1, right = n - 1;
        for(int i = 0; i < n - 2; i++){
            if(i >= 1 && nums[i] == nums[i-1])  continue;
            left = i + 1;
            right = n - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum - target == 0) return target;
                else{
                    if(sum > target){
                       right --;
                    }else {
                        left ++;
                    }
                    if(min > Math.abs(sum - target)) {
                        min = Math.abs(sum - target);
                        res = sum;
                    }
                }
            }
        }
        return res;
    }
}
