class MissingNumber {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        int len = A.length;
        boolean[] seen = new boolean[len];
        
        for(int val:A) {
            if(0 < val && val < len+1) {
                seen[val - 1] = true;
            }
        }
        
        for(int i=0; i<len;i++) {
            if(!seen[i]) {
                return i+1;
            }
        }
        
        return len+1;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        mn.solution(new int[]{1, 2, 3});
        mn.solution(new int[]{-1, -3});
        //mn.solution(new int[]{5, 8, 9, 10});       
    }
}