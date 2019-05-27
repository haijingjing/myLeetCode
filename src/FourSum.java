import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//18 四数之和
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        if(n < 4) return res;

        int left = 1, right = n-1;
        for(int i = 0; i < n - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n - 2; j ++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int sub = target - nums[i] - nums[j];
                left = j + 1;
                right = n - 1;
                while (left < right){
                    if(sub == nums[left] + nums[right]){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left ++;
                        right --;
                        while (left < right && nums[left] == nums[left - 1]) left ++;
                        while (left < right && nums[right] == nums[right + 1]) right --;
                    }else if(sub < nums[left] + nums[right]){
                        right --;
                    }else {
                        left ++;
                    }
                }
            }
        }
        return res;
    }
}
