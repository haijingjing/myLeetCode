import java.util.LinkedList;

public class FillingCar {


    public int solution(int[] A, int X, int Y, int Z) {
        int[] b = new int[A.length];
        for(int i = 0; i < A.length; i++){
            b[i] = 0;
        }
        LinkedList a = new LinkedList();
        int x1 = X, y1=Y, z1=Z;
        for(int i = 0; i < A.length; i++){
            if(X < A[i] && Y < A[i] && Z < A[i]){
                return -1;
            }
            if(X > A[i] && b[i] >= x1 - X){
                X  -= A[i];
            }else if( Y > A[i] && b[i] >= y1 - Y){
                Y -= A[i];
            }else if( Z > A[i] && b[i] >= z1 - Z){
                Z -= A[i];
            }else if(X > A[i] && (x1-X) < (y1-Y)){
                b[i] = x1 - X;
                X -= A[i];
            }else if(Y > A[i]){
                b[i] = y1 - Y;
            }else {
                b[i] = z1 - Z;
            }

        }
        return b[A.length-1];
    }
}
