import java.util.ArrayList;
import java.util.List;

//448 找出所有未在数组出现的数
//要求：o(n)时间复杂度,无额外空间
public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = - nums[index];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}
