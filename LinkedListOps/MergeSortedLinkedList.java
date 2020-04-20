
public class MergeSortedLinkedList {

    public static void main(String[] argv) {
        ListNode l1 = null, l2 = null;
        int[] a = {2};
        l1 = LinkedListUtility.buildLinkedListFromArray(a, 0, l1);
        int[] b = { 1 };
        l2 = LinkedListUtility.buildLinkedListFromArray(b, 0, l2);
        MergeSortedLinkedList m = new MergeSortedLinkedList();
        ListNode n = m.mergeTwoLists(l1, l2);
        LinkedListUtility.printLinkedList(n);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode s = new ListNode(0);
        ListNode h = merge(l1, l2, s);
        return h.next;
    }

    public ListNode merge(ListNode l1, ListNode l2, ListNode sorted) {
        if(l1==null) {
            return sorted.next = l2;
        } else if(l2 == null) {
            return sorted.next = l1;
        }
        if(l1.val <=l2.val) {
            sorted.next = l1;
            l1 = l1.next;
        } else {
            sorted.next = l2;
            l2 = l2.next;
        }
        
        ListNode h = merge(l1, l2, sorted.next);
        h = sorted;
        return h;
    }
}