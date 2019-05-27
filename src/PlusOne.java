//66 加一
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] res = new int[n + 1];
        int plus = 1;
        for(int i = n - 1; i >= 0; i --){
            digits[i] += plus;
            if(digits[i] >= 10){
                digits[i] %= 10;
            }else {
                plus = 0;
                break;
            }
        }
        if(plus == 1){
            res[0] = 1;
            for(int i = 0; i < n; i++){
                res[i + 1] = digits[i];
            }
            return res;
        }else {
            return digits;
        }
    }

    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 1;
        return nums;
    }
}
