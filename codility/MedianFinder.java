import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    /** initialize your data structure here. */

    private PriorityQueue<Integer> hi;
    private PriorityQueue<Integer> lo;

    public MedianFinder() {
        hi = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });
        lo = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        
        lo.add(num);
        
        hi.add(lo.peek());
        lo.remove();
        
        
        if(lo.size() < hi.size()) {
            lo.add(hi.peek());
            hi.remove();
        }
    }
    
    public double findMedian() {
        if(lo.size() > hi.size()) {
            return (double)lo.peek();
        }
        return (double) (lo.peek() + hi.peek()) / 2; 
    }



    public static void main(String[] args) {
        /*MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        System.out.println(mf.findMedian());*/
        
        System.out.println((int)3/2);
        System.out.println((int)5/2);
        System.out.println((int)6/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */