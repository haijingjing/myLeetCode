//647 回文字符串
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++) {
                if (isPalindromic(s, i, j)){
                    count ++;
                }
            }
        }
        return count;
    }

    private boolean isPalindromic(String s, int start, int end) {
        while (start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }else {
                start ++;
                end --;
            }
        }
        return true;
    }

    int count = 0;
    public int countSubstrings2(String s) {
        if(s == null || s.length() == 0) return 0;

        for(int i = 0; i < s.length(); i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);

        }
        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count ++;
            left --;
            right ++;
        }
    }
}
