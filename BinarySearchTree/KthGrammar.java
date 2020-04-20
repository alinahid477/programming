
public class KthGrammar {
// this is a perfect binary tree
    public static void main(String[] arr) {
        KthGrammar kg = new KthGrammar();
        int kth = kg.kthGrammar(4, 4);
        System.out.println(kth);
    }


    public int kthGrammar(int N, int K) {
        if(N==1 && K==1) {
            return 0;
        }else if(N==2 && K==1) {
            return 0;
        } else if(N==2 && K==2) {
            return 1;
        }
        
        int prevK = K/2+K%2;
        int val = this.kthGrammar(N-1, prevK);
        int leaves = (int)Math.pow(2, N-1);
        if(K > leaves/2) {
            if(K%2==1) {
                return val;
            } else {
                return val == 0 ? 1 : 0;
            }
            
        } else {
            if(K%2==1) {
                return val ;
            } else {
                return val == 0 ? 1 : 0;
            }
        }
    }
}