//704 二分查找
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            //右边界不能排除中位数，选左中位数
            int mid = (left + right) >>> 1;
            if(target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if(nums[left] == target){
            return left;
        }else {
            return -1;
        }
    }
}
