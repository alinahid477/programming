

public class MaxSlice {

    public int solution(int[] A) {

        int currentSlice = 0;
        int localSlice = 0;
        int maxSlice = Integer.MIN_VALUE;
        for(int i=0;i<A.length-1;i++) {
            currentSlice = localSlice + A[i];
            localSlice = Math.max(A[i], currentSlice);
            maxSlice = Math.max(localSlice, maxSlice);
        }

        return maxSlice;
    }

    public static void main(String[] argv) {
        MaxSlice ms = new MaxSlice();
        int sol = ms.solution(new int[] {-2, -3, 4, -1, -2, 1, 5, -3});

        System.out.println(sol);
    }
}