//29 两数相除
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1: 1;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res = 0;
        while (a >= b){
            long sum = b, count = 1;
            while (a >= (sum << 1)){
                sum <<= 1;
                count <<= 1;
            }
            a -= sum;
            res += count;
        }
        return sign > 0 ? res: -res;
    }
}
