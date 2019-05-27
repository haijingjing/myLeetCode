//9.回文数字
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        int res = 0, newRes =0;
        int num = x;
        while (x > 0){
            newRes = res * 10 + x % 10;
            if((newRes - x % 10)/10 != res){
                return false;
            }
            res = newRes;
            x = x / 10;
        }
        if(res == num){
            return true;
        }else return false;
    }
}
