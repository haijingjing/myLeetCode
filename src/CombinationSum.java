import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//39. 组合数
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(candidates.length == 0) return resultList;
        Arrays.sort(candidates);
        backTracing(resultList, new ArrayList<Integer>(), target, candidates, 0);
        return resultList;

    }

    private boolean backTracing(List<List<Integer>> resultList, ArrayList<Integer> temp, int remain, int[] candidates, int start) {
        if(remain == 0){
            resultList.add(new ArrayList<>(temp));
            return false;
        } else if(remain < 0){
            return false;
        }
        for(int i = start; i < candidates.length ; i++){
            temp.add(candidates[i]);
            boolean flag = backTracing(resultList, temp, remain - candidates[i], candidates, i);
            temp.remove(temp.size() - 1);
            if(!flag){
                break;
            }
        }
        return true;
    }
}
