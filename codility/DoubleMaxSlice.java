
public class DoubleMaxSlice {

    public int solition(int[] A) {
        int doubleMaxSlice = Integer.MIN_VALUE;

        int[] leftLocalMax = new int[A.length];
        int[] rightLocalMax = new int[A.length];
        
        int currentMax = 0, localMax = 0;

        for(int i=1; i<A.length; i++) {
            currentMax = localMax + A[i];
            localMax = Math.max(A[i], currentMax);
            leftLocalMax[i] = localMax;
        }

        currentMax = 0; localMax = 0;

        for(int i=A.length-2; i>0; i--) {
            currentMax = localMax + A[i];
            localMax = Math.max(A[i], currentMax);
            rightLocalMax[i] = localMax;
        }

        for(int i=1; i<A.length-1; i++) {
            doubleMaxSlice = Math.max(doubleMaxSlice, leftLocalMax[i-1]+rightLocalMax[i+1]);
        }

        return doubleMaxSlice;
    }

    public static void main(String[] argv) {
        DoubleMaxSlice dms = new DoubleMaxSlice();
        int sol = dms.solition(new int[] {3, 2, 6, -1, 4, 5, -1, 2} );
        System.out.println(sol);
    }
}