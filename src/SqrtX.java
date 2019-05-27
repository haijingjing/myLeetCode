//69. Sqrt(x)
public class SqrtX {
    public int mySqrt(int x) {
        double begin = 0;
        double end = x;
        double result = 1;
        double mid = 1;
        while (Math.abs(result - x) > 0.000001) {
            mid = (begin + end) / 2;
            result = mid * mid;
            if (result > x)   // 二分的范围
                end = mid;
            else begin = mid;
        }
        return (int) mid;
    }

    //牛顿迭代法
    public int mySqrt2(int x) {
        double pre = 0;
        double cur = x;           //  这里从x开始 从x/2开始会导致 1 不能满足  x(n+1)= xn - f'(xn)/f(xn)
        while(Math.abs(cur - pre) > 0.000001){
            pre = cur;
            cur = (pre/2 + x/(2*pre));
        }
        return (int)cur;
    }

    public int mySqrt3(int x) {
        int guess =  x/2 + 1;
        while (true) {
            if (guess * guess <= x && (guess + 1) * (guess + 1) > x)
                return guess;
            guess =(guess + x/guess)/2;
        }
    }

}
