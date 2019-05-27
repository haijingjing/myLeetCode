//14 最长公共前缀
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (max > strs[i].length()) {
                max = strs[i].length();
            }
        }
        boolean flag = false;
        int i;
        for(i = 0; i < max; i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(c != strs[j].charAt(i)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        return strs[0].substring(0, i);
    }
}
