import org.junit.Test;

//153 寻找旋转数组中的最小值
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        else if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if(nums[mid] >= nums[left] && nums[left] > nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }
    public int findMin2(int[] nums) {
        if(nums.length == 0) return -1;
        else if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }


    @Test
    public void test(){
        int[] nums = {3,4,5,1,2};
        int min = this.findMin(nums);
        System.out.println(min);
    }
}
