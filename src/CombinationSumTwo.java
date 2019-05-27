import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40 组合数2
public class CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrace(res, new ArrayList<>(),candidates, target, 0);
        return res;
    }

    private boolean backTrace(List<List<Integer>> res, ArrayList<Integer> temp, int[] nums, int remain, int start) {
        if(remain == 0 && !res.contains(temp)){
            res.add(new ArrayList<>(temp));
            return false;
        }else if(remain < 0){
            return false;
        }
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            boolean flag = backTrace(res, temp, nums, remain - nums[i], i + 1);
            temp.remove(temp.size() - 1);
            if(!flag) break;
        }
        return true;
    }
}
