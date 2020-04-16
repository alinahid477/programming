
public class LinkedListSwapPairs {
    
    public static void main(String[] argv) {
        ListNode head = null;
        int[] vals = new int[] {1,2,3,4};
        LinkedListSwapPairs llswp = new LinkedListSwapPairs();
        head  = LinkedListUtility.buildLinkedListFromArray(vals, 0, head);
        LinkedListUtility.printLinkedList(head);
        head = llswp.swapPairs(head);
        System.out.println("Head:"+head.val);
        LinkedListUtility.printLinkedList(head);
    }



    

    private ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = swapNode(head, head.next);
        if(firstNode.next.next == null) {
            return firstNode;
        }
        firstNode.next.next = swapPairs(firstNode.next.next);
        return firstNode;
    }

    private ListNode swapNode(ListNode a, ListNode b) {
        ListNode tmp = a;
        a.next = b.next;
        b.next = tmp;
        return b;
    }
}