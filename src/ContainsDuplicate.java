import java.util.HashSet;

//217 包含重复
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }else {
                set.add(num);
            }
        }
        return false;
    }
}
