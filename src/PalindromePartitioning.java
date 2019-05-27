import java.util.ArrayList;
import java.util.List;

//131 回文部分
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backTrace(res, new ArrayList<String>(), s);
        return res;
    }

    private void backTrace(List<List<String>> res, ArrayList<String> temp, String s) {
        if(s.length() == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int j = 1; j < s.length() + 1; j ++){
            String cur = s.substring(0, j);
            if(!isPalindrome(cur)) continue;
            temp.add(cur);
            backTrace(res, temp, s.substring(j));
            temp.remove(temp.size() -  1);
        }

    }

    boolean isPalindrome(String s){
        int n = s.length();
        if(n == 0) return false;
        for(int i = 0; i < n/2 + 1; i ++){
            if(s.charAt(i) != s.charAt(n - i - 1)){
                return false;
            }
        }
        return true;
    }
}
