//34 在排序数组中查找元素的第一个和最后一个位置
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                int temp = mid;
                while (0 <= temp && nums[temp] == target) temp --;
                while (mid <= nums.length - 1 && nums[mid] == target) mid ++;
                return new int[]{++ temp, -- mid};
            }else if(nums[mid] > target){
                right = mid - 1;
            }else left = mid + 1;
        }
        return new int[]{-1, -1};
    }
}
