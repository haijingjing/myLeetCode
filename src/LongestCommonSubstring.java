//最长重复子串
public class LongestCommonSubstring {
    class TrieNode{
        boolean isWord;
        TrieNode[] next;
        int count; // 重要，用来保存有几个 word 的前缀共用当前的字符串
        public TrieNode(){
            isWord = false;
            next = new TrieNode[26];
            count = 0;
        }
    }

    public String LCS(String str){
        if(str == null || str.length() == 0) return "";

        TrieNode root = new TrieNode();
        buildSuffixTrie(str,root);

        return longestCommonSuffix(root, "");

    }

    public void buildSuffixTrie(String str, TrieNode root){
        if(str == null || str.length() == 0)
            return;

        for(int i = 0; i < str.length(); i++){
            String tmp = str.substring(i);
            TrieNode node = root;
            for(int j = 0; j < tmp.length(); j++){
                int index = tmp.charAt(j) - 'a';
                if(node.next[index] == null){
                    node.next[index] = new TrieNode();
                }else {
                    node.next[index].count++;
                }

                node = node.next[index];
            }
            node.isWord = true;
        }
    }

    public String longestCommonSuffix(TrieNode root, String cur_prefix){
        if(root == null) return "";

        String res = cur_prefix;
        for(int i = 0; i < 26; i++){
            String tmp = cur_prefix;

            if(root.next[i] != null){
                if(root.next[i].count <= 0){
                    break;
                }
                tmp = longestCommonSuffix(root.next[i], cur_prefix + String.valueOf(((char)('a'+i))));
            }

            if(tmp.length() > res.length())
                res = tmp;
        }

        return res;
    }



    public static void main(String[] args){
        LongestCommonSubstring test = new LongestCommonSubstring();
        System.out.println(test.LCS("abczzacbc"));
    }

    public static String maxRepat(String input) {
        if(input == null || input.length() == 0){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int k = Integer.MIN_VALUE;
        int first = 0;
        for (int i = 1; i < input.length(); i++) {
            for (int j = 0; j < input.length() - i; j++) {
                if(input.charAt(j) == input.charAt(i + j)){
                    k++;
                }else{
                    k = 0;
                }

                if(k > max){
                    max = k;
                    first = j - k + 1;
                }
            }
        }

        return input.substring(first, first + max);
    }

}
