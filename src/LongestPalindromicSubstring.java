/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring {

    int max = 0;
    int start = 0;
    private void searchPalindromic(char[] a, int left, int right) {
        while (left > 0 && right < a.length){
            if(a[left] == a[right]) {
                if(right - left + 1 > max){
                    max = right - left + 1;
                    start = right;
                }
                left--;
                right++;
            }else {
                break;
            }
        }
    }
    public String longestPalindrome(String s) {
        char[] a = s.toCharArray();
        int length = s.length();
        if(length  < 2){
            return s;
        }

        for(int i = 0; i < length;i++){
            searchPalindromic(a, i, i);
            searchPalindromic(a, i, i + 1);
        }
        return s.substring(start, start + max);

        /*for(int i = 0; i< length; i++) {
            for (int j = 1; i >= j && i + j <= length - 1; j++) {
                if (a[i - j] == a[i + j]) {
                    if(2 * j + 1 > max){
                        max = 2 * j + 1;
                        start = i - j ;
                    }
                }else {
                    break;
                }
            }

        }

        for(int i = 0; i< length; i++) {
            for (int j = 0; i >= j && i + j < length - 1; j++) {
                if (a[i - j] == a[i + j + 1]) {
                    if(2 * j + 2 > max){
                        max = 2 * j + 2;
                        start = i - j;
                    }
                }else {
                    break;
                }
            }
        }
        return s.substring(start, start + max);*/
    }


}
