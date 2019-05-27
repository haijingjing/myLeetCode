//72 编辑距离（考察两个字符串的相似度）

public class EditDistance {
    public int minDistance(String word1, String word2) {
       int l1 = word1.length();
       int l2 = word2.length();
       if(l1 == 0 || l2 == 0){
           return l1 == 0 ? l2 : l1;
       }
       int[][] dp = new int[l1 + 1][l2 + 1];
       for(int i = 0; i <= l1; i++){
           dp[i][0] = i;
       }
       for(int j = 0; j <= l2; j++){
           dp[0][j] = j;
       }
       for(int i = 0; i < l1; i++){
           for(int j = 0; j < l2; j++){
               if(word1.charAt(i) == word2.charAt(j)){
                   dp[i+1][j+1] = dp[i][j];
               }else {
                   int replace = dp[i][j] + 1;
                   int insert = dp[i][j+1] + 1;
                   int delete = dp[i+1][j] + 1;

                   int min = Math.min(replace, insert);
                   min = Math.min(min, delete);

                   dp[i+1][j+1] = min;
               }
           }
       }
       return dp[l1][l2];
    }
}
