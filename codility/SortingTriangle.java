import java.util.Arrays;

public class SortingTriangle {
    public static void main(String[] argv) {

    }

    public int solution(int[] A) throws Exception {
        int len = A.length;
        if(len < 3) {
            throw new Exception("Invalid Array.");
        }
        Arrays.sort(A);
        for(int i=0; i< len - 2; i++) {
            if(A[i]+A[i+1] > A[i+2]) {
                return 1;
            }
        }
        return 0;
    }
}