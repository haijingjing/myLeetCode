//38 报数
public class CountandSay {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        StringBuffer sb =  new StringBuffer();
        sb.append("1");
        int k = 1;
        for(int i = 1; i < n ; i++){
            StringBuffer nsb =  new StringBuffer();
            for(int j = 0; j < sb.length(); j++){
                k = 1;
                while (j < sb.length()-1 && (sb.charAt(j+1) == sb.charAt(j))){
                    j ++;
                    k ++;
                }
                nsb.append(k).append(sb.charAt(j));
            }
            sb = nsb;
        }
        return sb.toString();
    }
}
