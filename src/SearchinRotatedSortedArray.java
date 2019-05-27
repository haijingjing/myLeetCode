//33 搜索旋转排序数组
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        int low = 0, high = n-1;
        while (low < high){
            int mid = (low + high) / 2;//为了避免超内存，应该用 mid = low +(high-low)/2
            if(nums[mid] == target) return mid;
            else if(nums[low] == target) return low;
            else if(nums[high] == target) return high;
            else if(nums[mid] < nums[high]){
                if(target > nums[mid] && target < nums[high]){
                    low = mid + 1;
                }else {
//                    if(target > nums[high] || target < nums[mid]){//这个if可以不用写
                    high = mid - 1;
                }
            }else if(nums[mid] > nums[high]){
                if(target > nums[low] && target < nums[mid]){
                    high = mid - 1;
                }else{
//                    if(target < nums[low] || target > nums[mid]){
                    low = mid + 1;
                }
            }
        }
        if(nums[(low+high)/2] == target) return (low+high)/2;
        return  -1;
    }
}
