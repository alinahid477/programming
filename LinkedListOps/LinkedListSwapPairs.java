
public class LinkedListSwapPairs {
    
    public static void main(String[] argv) {
        ListNode head = null;
        int[] vals = new int[] {1,2,3,4};
        LinkedListSwapPairs llswp = new LinkedListSwapPairs();
        head  = llswp.buildLinkedListFromArray(vals, 0, head);
        llswp.printLinkedList(head);
        head = llswp.swapPairs(head);
        System.out.println("Head:"+head.val);
        llswp.printLinkedList(head);
    }



    private ListNode buildLinkedListFromArray(int[] vals, int index, ListNode head) {
        head = new ListNode(vals[index]);
        if(vals.length - 1 <= index) {
            return head;
        }
        head.next = buildLinkedListFromArray(vals, index+1, head.next);
        return head;
    }

    private void printLinkedList(ListNode head) {
        if(head == null) return;
        System.out.print(head.val);
        if(head.next == null) {
            return;
        }        
        System.out.print("->");
        printLinkedList(head.next);
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