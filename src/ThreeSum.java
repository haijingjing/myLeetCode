import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 三数之和
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n < 3) return res;
        int left = 1, right = n - 1;
        for(int i = 0; i < n; i++){
            if(i >= 1 && nums[i] == nums[i-1]){
                continue;
            }
            left = i + 1;
            right = n - 1;
            while (left < right){
                if (nums[left] + nums[right] + nums[i] == 0){
                    res.add(Arrays.asList(nums[i],nums[left], nums[right]));
                    left ++;
                    right --;
                    while (left < right && nums[left] == nums[left - 1]) left ++;  // skip same result
                    while (left < right && nums[right] == nums[right + 1]) right --;
                }else if(nums[left] + nums[right] + nums[i] < 0){
                    left ++;
                }else {
                    right --;
                }
            }
        }
        return res;
    }

}
