import java.util.Arrays;
import java.util.Collections;
//状态转移方程： d[i,j] = d[i-1,j] || d[i-1,j]+h(i)
public class ItemsAndPerson {

    public ItemsAndPerson(){}

    public int getLessTime(Integer[] a, int m){
        int n = a.length;
        int k = 0;
        Arrays.sort(a,Collections.reverseOrder());//从大到小排序
        int[][] d = new int[n][m];
        d[0][0]=a[0];
        for(int i = 1; i < n; i++){
            k = getMin(m, k, d[i - 1]);
            for(int j = 0; j < m; j++){
                if(j == k){
                    d[i][j] = d[i-1][j]+a[i];
                }else {
                    d[i][j] = d[i-1][j];
                }
            }
        }
        k = getMax(m, d[n - 1], k);
        return d[n-1][k];
//        System.out.println(d[n-1][k]);
    }

    private int getMax(int m, int[] ints, int k) {
        int max = 0;
        for(int j = 0; j < m ;j++){
            if(ints[j]> max){
                max = ints[j];
                k = j;
            }
        }
        return k;
    }

    private int getMin(int m, int k, int[] ints) {
        int min = 99999;
        for(int j = 0; j < m ;j++){
            if(ints[j] < min){
                min = ints[j];
                k = j;
            }
        }
        return k;
    }
}
