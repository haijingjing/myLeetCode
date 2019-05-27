import java.util.ArrayList;
import java.util.List;

//216 组合数3
public class CombinationSumThree {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private boolean backTrace(List<List<Integer>> res, ArrayList<Integer> temp, int remain, int k, int start) {
        if(temp.size() > k){
            return false;
        }
        if(remain == 0 && temp.size() == k){
            res.add(new ArrayList<>(temp));
            return false;
        }else if(remain < 0){
            return false;
        }
        for(int i = start; i <= 9; i++){
            temp.add(i);
            boolean flag = backTrace(res, temp,  remain - i, k, i + 1);
            temp.remove(temp.size() - 1);
            if(!flag) break;
        }
        return true;
    }
}
