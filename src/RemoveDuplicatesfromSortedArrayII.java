//80 从排序数组中删除重复元素2
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0) return n;
        int j = 2;
        for(int i = 2; i < n; i++){
            if(nums[i] == nums[j] && nums[i] == nums[j-1]){
                continue;
            }else {
                nums[j ++] = nums[i];
            }
        }
        return j;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
