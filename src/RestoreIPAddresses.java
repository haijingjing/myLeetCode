import java.util.ArrayList;
import java.util.List;

//93 复原IP地址
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() > 12 || s.length() < 4) return res;
        dfs(s, "", res, 1);
        return res;
    }

    private void dfs(String s, String temp, List<String> res, int count) {
        if(count == 4 && isVaild(s)){
            res.add(temp + s);
            return;
        }
        for(int i = 1; i < Math.min(4, s.length()); i ++){
            String cur = s.substring(0, i);
            if(isVaild(cur)){
                dfs(s.substring(i), temp + cur + ".", res, count + 1);
            }
        }
    }

    private boolean isVaild(String s) {
        if(s.charAt(0) == '0'){
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        return num > 0 && num < 256;
    }

    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        helper(s, "", res, 0);
        return res;
    }

    private void helper(String s, String temp, List<String> res, int n) {
        if(s.length() > 3 * (4 - n)){
            return;
        }
        if(n == 4){
            if(s.length() == 0){
                res.add(temp.substring(0,temp.length() - 1));
                return;
            }
        }
        for(int i = 1; i <= 3; i ++){
            if(s.length() < i){
                break;
            }
            int val = Integer.parseInt(s.substring(0, i));
            if(val > 255 || i != String.valueOf(val).length()) continue;
            helper(s.substring(i),temp + s.substring(0, i) + ".", res, n + 1);

        }
    }


}
