import java.util.Arrays;
import java.util.stream.Collectors;

public class SortingLargestProduct {

    public static void main (String[] argv) {

    }

    public int solution(int[] A) throws Exception {
        Arrays.sort(A);
        int result1=0, result2=0, len = A.length;
        if(len > 2) {
            result1 = A[len -1] * A[len -2] * A[len-3];
            result2 = A[0] * A[1] * A[len-1];
            if(result1 > result2) {
                return result1;
            } else {
                return result2;
            }
        }
        
        Arrays.stream(A).boxed().collect(Collectors.toSet()).size();
        return 0;
    }
}