//43 字符串相乘
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        //m位数乘以n位数，结果最多为m+n位数
        int n = l1 + l2, n2 = n;
        int[] num = new int[n];
        int sum = 1;
        for(int j = l2 - 1; j >= 0; j --){
            n = n2;
            for(int i = l1 - 1; i >= 0; i --){
                sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                num[n - 1] += sum % 10;
                num[n - 2] += sum / 10 + num[n - 1]/10;
                num[n - 1] %= 10;
                n --;
            }
            n2 --;
        }
        int i = 0;
        n = num.length;
        while (i < n && num[i] == 0) i++;
        if(i == n) return "0";
        StringBuffer sb = new StringBuffer();
        while (i < n){
            sb.append(num[i++]);
        }
        return sb.toString();
    }

    public String multiply2(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
