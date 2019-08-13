import org.junit.Test;

//287 找到重复数字
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right){
            //右边不收缩，取左中位数
            int mid = (left + right) >>> 1;
            int count = countNums(nums, left, mid);
            if(count > mid - left + 1){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int countNums(int[] nums, int left, int mid) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= left && nums[i] <= mid){
                count ++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        int[] nums = {1,3,4,2,2};
        int count = this.findDuplicate(nums);
        System.out.println(count);
    }
}
