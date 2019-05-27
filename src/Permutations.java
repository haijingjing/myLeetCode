import java.util.ArrayList;
import java.util.List;

//46 全排列
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        backTrace(res, new ArrayList<>(), nums);
        return res;
    }

    private void backTrace(List<List<Integer>> res, ArrayList<Integer> list, int[] nums) {
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int j = 0; j < nums.length; j ++){
            if(list.contains(nums[j])) continue;
            list.add(nums[j]);
            backTrace(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
