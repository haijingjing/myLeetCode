import java.util.Scanner;
//16进制加法
public class Plus{

    public static int transfer(char[] a){
        int sum = 0;
        for(int i=0; i<a.length;i++){
            sum *=16;
            if(a[i]>='A'){
                sum += a[i]-'A'+10;
            }else {
                sum += a[i]-'0';
            }
        }
        return sum;
    };
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String a = input.next();
        String b = input.next();
//        String a="5A";
//        String b="B1";
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int suma = transfer(as);
        int sumb  = transfer(bs);
        int[] c = new int[1000];
        int sum = suma+sumb;
        int i = 0;
        for(; ;i++){
            c[i] = sum%16;
            if(sum/16==0){
                break;
            }else {
                sum = sum/16;
            }
        }
        for(int j=i;j>=0; j--){
            if(c[j]>9){
                switch(c[j]) {
                    case 10:
                        System.out.print("A");
                        break;
                    case 11:
                        System.out.print("B");
                        break;
                    case 12:
                        System.out.print("C");
                        break;
                    case 13:
                        System.out.print("D");
                        break;
                    case 14:
                        System.out.print("E");
                        break;
                    case 15:
                        System.out.print("F");
                        break;
                }
            }else {
                System.out.print(c[j]);
            }
        }
        System.out.println();

    }

}