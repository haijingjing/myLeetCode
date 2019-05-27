import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//78 子集
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length == 0) return res;
        backTrace(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }

    private void backTrace(List<List<Integer>> res, ArrayList<Integer> temp, int start, int[] nums) {
        res.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backTrace(res, temp,i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
