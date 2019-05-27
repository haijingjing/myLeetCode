import java.util.ArrayList;
import java.util.List;

//17.电话号码的字母组合
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        String[] dict ={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int[] nums = new int[digits.length()];
        for(int i = 0; i < digits.length(); i++){
            nums[i] = digits.charAt(i) - '0';
        }
        combin(res, new StringBuffer(),dict, nums, 0);
        return res;
    }

    private void combin(List<String> res, StringBuffer sb, String[] dict, int[] nums, int i) {
        if(i == nums.length){
            res.add(sb.toString());
            return;
        }
        for(int j = 0; j < dict[nums[i]].length(); j++){
            sb.append(dict[nums[i]].charAt(j));
            combin(res, sb, dict, nums, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
}
