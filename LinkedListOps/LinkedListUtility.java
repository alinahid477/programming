
public class LinkedListUtility {
    public static ListNode buildLinkedListFromArray(int[] vals, int index, ListNode head) {
        head = new ListNode(vals[index]);
        if(vals.length - 1 <= index) {
            return head;
        }
        head.next = buildLinkedListFromArray(vals, index+1, head.next);
        return head;
    }

    public static void printLinkedList(ListNode head) {
        if(head == null) return;
        System.out.print(head.val);
        if(head.next == null) {
            return;
        }        
        System.out.print("->");
        printLinkedList(head.next);
    }
}