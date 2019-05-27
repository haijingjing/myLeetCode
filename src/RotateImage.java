//48 旋转图片(n * n 的图片)
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        rotate(matrix, 0, n - 1);
    }

    private void rotate(int[][] matrix, int start, int end) {
        if(start >= end) return;

        int pre;
        int next;

        for(int i = start; i < end; i++ ){
            pre = matrix[start][i];
            next = matrix[i][end];

            matrix[i][end] = pre;
            pre = next;
            next = matrix[end][end+start-i];
            matrix[end][end+start-i] = pre;
            pre = next;
            next = matrix[end+start-i][start];
            matrix[end+start-i][start] = pre;
            pre = next;
            matrix[start][i] = pre;
        }
        rotate(matrix, start + 1, end - 1);
    }

    /**
     * 解题思路
     * 先根据对角线翻转，然后在垂直中轴线翻转
     */
    public void rotate2(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
