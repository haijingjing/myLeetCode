//59 螺旋矩阵2
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int x = 0, y = n - 1;

        int i = 1;
        while(x < y){
            int start = x;
            int end = y;
            while (x <= y){
                matrix[start][x ++] = i ++;
            }
            x = start;
            while (x < y) {
                matrix[++ x][end] = i ++;
            }
            while (x > start) {
                matrix[end][-- x] = i ++;
            }
            while (y > start + 1){
                matrix[-- y][start] = i ++;
            }
            x = start + 1;
            y = end - 1;
        }
        if(x == y){
            matrix[x][x] = i ++;
        }
        return matrix;
    }
}
