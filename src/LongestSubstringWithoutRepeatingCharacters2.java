import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters2 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int left = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int right =0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right),right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
