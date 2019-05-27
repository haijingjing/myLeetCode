import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int anotherKey = target - nums[i];
            if(map.containsKey(anotherKey)){
                result[0] = map.get(anotherKey);
                result[1] = i;
                if(result[0] != result[1]){
                    return result;
                }
            }
            else {
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
