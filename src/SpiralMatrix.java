import java.util.ArrayList;
import java.util.List;

//54 螺旋矩阵
public class SpiralMatrix {
    List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return res;
        int n = matrix[0].length;
        if(n == 0) return res;
        spiral(matrix, 0, n, m);
        return res;
    }

    private void spiral(int[][] matrix, int start, int n, int m) {
        if(start > m - 1 || start > n - 1) return;
        if(start == m - 1){
            for(int i = start; i < n; i++){
                res.add(matrix[start][i]);
            }
            return;
        }else if(start == n - 1){
            for (int i = start; i < m; i++) {
                res.add(matrix[i][start]);
            }
            return;
        }else {
            for (int i = start; i < n; i++) {
                res.add(matrix[start][i]);
            }
            for (int i = start + 1; i < m; i++) {
                res.add(matrix[i][n - 1]);
            }
            for (int i = n - 2; i >= start; i--) {
                res.add(matrix[m - 1][i]);
            }
            for (int i = m - 2; i > start; i--) {
                res.add(matrix[i][start]);
            }
        }

        spiral(matrix, start + 1, n - 1, m - 1);
    }
}
