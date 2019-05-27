//504. 七进制数
public class Base7 {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        boolean flag = true;
        if(num < 0) flag = false;
        num =  Math.abs(num);
        StringBuffer sb = new StringBuffer();
        while (num > 0){
            sb.insert(0,num % 7);
            num = num / 7;
        }
        if(!flag){
            sb.insert(0,"-");
        }
        return sb.toString();
    }

    public String convertTo7(int num) {
        if (num < 0)
            return '-' + convertTo7(-num);
        if (num < 7)
            return num + "";
        return convertTo7(num / 7) + num % 7;
    }
}
