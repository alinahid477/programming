public class MaxCounter {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        
        int effective_max_counter = 0;
        int last_counter = 0;
        
        int[] sol = new int[N];
        
        for(int i=0; i<A.length; i++) {
            if(A[i] == N+1) {
               effective_max_counter = last_counter;
            } else {
                sol[A[i]-1] = Math.max(effective_max_counter, sol[A[i]-1]);
                sol[A[i]-1]++;
                last_counter = Math.max(last_counter, sol[A[i]-1]);
            }
        }
        
        for(int i=0; i<N; i++) {
            sol[i] = Math.max(effective_max_counter, sol[i]);
        }
        
        return sol;
    }

    public static void main(String[] argv) {
        MaxCounter mc = new MaxCounter();
        mc.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
    }
}