import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//47 全排列2
public class PermutationsTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];//默认全是false
//        Arrays.fill(flag, false);
        backTrace(res, new ArrayList<>(), nums, flag);
        return  res;

    }

    private void backTrace(List<List<Integer>> res, ArrayList<Integer> temp, int[] nums, boolean[] flag) {
        if(temp.size() == nums.length && !res.contains(temp)){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int j = 0; j < nums.length; j++){
            if(flag[j]) continue;
            if(j > 0 && nums[j - 1] == nums[j] && !flag[j - 1]) continue;

            temp.add(nums[j]);
            flag[j] = true;
            backTrace(res, temp, nums, flag);
            temp.remove(temp.size() - 1);
            flag[j] = false;
        }
    }
}
