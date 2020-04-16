
public class LinkedListReverse {
    public static void main(String[] argv) {
        
        LinkedListReverse llr = new LinkedListReverse();
        int[] vals = new int[]{1,2,3,4,5};        
        ListNode head1 = null, head2 = null;
        head1 = LinkedListUtility.buildLinkedListFromArray(vals, 0, head1);
        head1 = llr.reverseRecursive(head1);
        LinkedListUtility.printLinkedList(head1);
        System.out.println("");
        head2 = LinkedListUtility.buildLinkedListFromArray(vals, 0, head2);
        head2 = llr.reverseLoop(head2);
        LinkedListUtility.printLinkedList(head2);
    }

    public ListNode reverseRecursive(ListNode current) {
        if(current==null || current.next==null) {
            return current;
        }
        
        ListNode head = reverseRecursive(current.next);
        current.next.next = current;
        current.next = null;
        return head;
    }

    public ListNode reverseLoop(ListNode head) {
    
       ListNode prev = null;
       ListNode current = head;
       ListNode next = null;
       while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
       }
       //head.next = null;
       return prev;
    }
}