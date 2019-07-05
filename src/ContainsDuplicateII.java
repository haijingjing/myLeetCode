import java.util.HashMap;

//219 包含重复II
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && (i - map.get(nums[i]).intValue() <= k)){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
