import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0){
            return 0;
        }
        char[] c = s.toCharArray();
        int[] d = new int[s.length()];
        d[0] =1;
        int max = 1;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put(c[0],0);

        for(int i = 1; i < s.length(); i ++){
            if(map.containsKey(c[i])){
                d[i] =Math.min(i - map.get(c[i]),d[i-1]+1) ;
            }else {
                d[i] = d[i-1] + 1;
            }
            map.put(c[i],i);
            max = Math.max(max,d[i]);
        }
        return max;
    }
}
