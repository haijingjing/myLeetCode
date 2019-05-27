//12 数字转罗马数字
public class IntegertoRoman {
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        if(num/1000 > 0){
            for(int i = 0; i < num/1000; i++){
                sb.append("M");
            }
            num %= 1000;
        }
        if(num/100 == 4 || num/100 == 9){
            if(num/100 == 4){
                sb.append("CD");
            }else{
                sb.append("CM");
            }
        }else{
            if(num/100 >= 5) {
                sb.append("D");
                num -= 500;
            }
            for(int i = 0; i < num/100; i++){
                sb.append("C");
            }
        }
        num %= 100;
        if(num/10 == 4 || num/10 == 9){
            if(num/10 == 4){
                sb.append("XL");
            }else {
                sb.append("XC");
            }
        }else {
            if(num/10 >= 5){
                sb.append("L");
                num -= 50;
            }
            for(int i = 0; i < num/10; i++){
                sb.append("X");
            }
        }
        num %= 10;

        if(num == 4 || num == 9){
            if(num == 4){
                sb.append("IV");
            }else {
                sb.append("IX");
            }
        }else {
            if(num >= 5){
                sb.append("V");
                num -= 5;
            }
            for(int i = 0; i < num; i++){
                sb.append("I");
            }
        }
        return sb.toString();
    }

    public static String intToRoman2(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
