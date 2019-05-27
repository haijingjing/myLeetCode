// 189 旋转数组
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(k == 0) return;
        int temp = 0;
        reverse(nums, 0, n -1, temp);
        reverse(nums, 0, k - 1, temp);
        reverse(nums, k, n -1, temp);
    }

    private void reverse(int[] nums, int start, int end, int temp) {
        while (start < end){
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start ++;
            end --;
        }
    }
}
