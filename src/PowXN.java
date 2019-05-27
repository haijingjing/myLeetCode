//50. Pow(x, n)
public class PowXN {
    //Time Limit Exceeded 超时了
    public double myPow2(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return (double)1/x;
        if(n % 2 ==0) {
            return myPow2(x, n / 2) * myPow(x, n / 2);
        }else if(n > 0){
            return myPow2(x, n / 2) * myPow(x, n / 2) * x;
        }else {
            return myPow2(x, n / 2) * myPow(x, n / 2) * myPow(x, -1);
        }
    }

    //我提交的正确答案
    public double myPow4(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == 2) return x * x;
        if(n == -1) return (double)1/x;
        if(n % 2 ==0) {
            return myPow4(myPow4(x, n / 2), 2);
        }else if(n > 0){
            return myPow4(myPow4(x, n / 2), 2) * x;
        }else {
            return myPow4(myPow4(x, n / 2), 2) * myPow4(x, -1);
        }
    }
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 2) return x * x;
        if(n < 0){
            n = - n;
            x = (double) 1/x;
        }
        if(n % 2 ==0) {
            return myPow(myPow(x, n / 2), 2);
        }else {
            return myPow(myPow(x, n / 2), 2) * x;
        }
    }


    //discuss里面的答案，因为n is a 32-bit signed integer, within the range [-2^31, 2^31-1]
    //当n为Integer.MIN_VALUE的时候，会数组越界
    public double myPow3(double x, int n) {
        if(n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            return myPow(x * x, -(n / 2));
        }
        if(n < 0){
            n = - n;
            x = (double) 1/x;
        }
        //评论补充的答案

        if(n % 2 == 0){
            return myPow3(x * x, n / 2);
        }else return myPow3(x * x, n / 2) * x;
    }

}
