import java.util.ArrayList;
import java.util.List;

//763 划分字母区间
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26]; //记录每个字符最后出现的索引
        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }

        int last = 0, start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
