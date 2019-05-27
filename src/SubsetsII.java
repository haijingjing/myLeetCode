import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90 子集2
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(res, new ArrayList<Integer>(), nums, 0);
        return  res;

    }

    private void backTrace(List<List<Integer>> res, ArrayList<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            temp.add(nums[i]);
            backTrace(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
