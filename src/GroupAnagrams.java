import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//49 异序词分组
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String str1 = new String(c);
            if(!map.containsKey(str1)){
                map.put(str1,new ArrayList<String>());
            }
            map.get(str1).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
