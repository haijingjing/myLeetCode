public class MaxSumDistance {
    public int solution(int[] A) {
        int sum1 = Integer.MIN_VALUE;
        int sum2 = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            sum1 = Math.max(A[i] - i, sum1);
            sum2 = Math.max(A[i] + i, sum2);
        }
        return sum1 + sum2;
    }
}
