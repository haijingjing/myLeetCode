// 35 查找插入位置
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else low = mid + 1;
        }
        return low;
    }

    //use template
    public int searchInsert2(int[] nums, int target){
        int low = 0, high = nums.length;
        while (low < high){
            int mid = (low + high) >>> 1;
            if(nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }
}
