//367 有效的完全平方数
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        long low = 0;
        long high = num/2 + 1;
        long mid = 0;
        while (low <= high){
            mid = low + (high - low)/2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid > num){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return false;
    }
}
