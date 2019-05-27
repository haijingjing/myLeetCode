//136 单独的数
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum ^= num;
        }
        return sum;
    }
}
