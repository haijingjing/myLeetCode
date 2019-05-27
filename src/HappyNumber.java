import java.util.HashSet;

//202. 快乐数
public class HappyNumber {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int sum = 0;
        while (true){
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }

            if(set.contains(sum) || sum == 1){
                break;
            }
            set.add(sum);
            n = sum;
            sum = 0;
        }
        if(sum == 1) return true;
        else return false;
    }
}
