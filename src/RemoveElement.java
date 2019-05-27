//27 移除数组元素
public class RemoveElement {
    public void swap(int[] a, int left, int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            while (left <= right && nums[right] == val) {
                right--;
            }
            while (left <= right && nums[left] != val) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        return left;
    }

    public int removeElement2(int[] nums, int val) {
        int length = nums.length;
        int m = 0;
        for(int i = 0; i < length; i++){
            if(nums[i] != val){
                nums[m ++] = nums[i];
            }
        }
        return m;
    }
}
