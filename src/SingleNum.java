public class SingleNum {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        for(int i = 1; i< len; i++){
            sum ^= nums[i];
        }
        return sum;
    }
}
