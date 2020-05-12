import org.junit.Test;

public class SingleElementInASortedArray {
    // normal solution, O(n)
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if( n == 1) return nums[0];
        for( int i = 0; i < n - 1; i = i + 2) {
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[n - 1];
    }

    // Bitwise operation solution, like 136, single number, O(n)
    // 0 ^ NumA = NumA;   NumA ^ NumA = 0;
    public int singleNonDuplicate1(int[] nums) {
        int res = 0;
        for(int num: nums){
            res ^= num;
        }
        return res;
    }

    //TODO: use binary search
    public int singleNonDuplicate2(int[] nums) {
        return 0;
    }
    @Test
    public void test(){
        int[] nums = {1,1,3,3,4,4,8,8,9};
        int res = this.singleNonDuplicate1(nums);
        System.out.println(res);
    }
}
