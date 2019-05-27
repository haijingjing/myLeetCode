import java.util.Arrays;

//31 下一个排列
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for(int j = n - 1; j >= i; j --){
                    if(nums[j] > nums[i-1]){
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        reverse(nums, i, n-1);
                        return;
                    }
                }
            }
        }
        reverse(nums,0,n - 1);
        return;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}
