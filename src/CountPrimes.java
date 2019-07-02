//204 计算质数
public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 1; i < n; i++){
            if(isPrime(i)){
                count ++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    // Sieve of Eratosthenes 厄拉多塞筛法
    public int countPrimes2(int n) {
        boolean[] flag = new boolean[n];//default false
        int count = 0;
        for(int i = 2; i < n; i++){
            if(!flag[i]){
                count++;
                for(int j = 2; i * j < n; j++){
                    flag[i*j] = true;
                }
            }
        }
        return count;
    }

    //optimize
    public int countPrimes3(int n) {
        if(n <= 1) return 0;
        boolean[] flag = new boolean[n];//default false
        flag[0] = true;
        flag[1] = true;
        for(int i = 2; i < Math.sqrt(n); i++){
            if(!flag[i]){
                for(int j = 2; i * j < n; j++){
                    flag[i*j] = true;
                }
            }
        }
        int count = 0;
        for(int i = 2; i< flag.length; i++){
            if(!flag[i]) count++;
        }
        return count;
    }


}
