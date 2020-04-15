import java.util.Arrays;

public class RecursiveReverse {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static void main(String[] argv) {
        System.out.println(new RecursiveReverse().reverseRecursion("This is a recursions."));
        System.out.println("");
        System.out.println(new RecursiveReverse().reverseLoop("This is a recursion."));
        char[] arr = new char[] {'h','e','l','l','o'};
        arr = new RecursiveReverse().reverseRecursionArr(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        ListNode head = null;
        int[] vals = new int[] {1,2,3,4};
        RecursiveReverse rr = new RecursiveReverse();
        head  = rr.buildLinkedListFromArray(vals, 0, head);
        rr.printLinkedList(head);
        head = rr.swapPairs(head);
        System.out.println("Head:"+head.val);
        rr.printLinkedList(head);
    }

    private String reverseRecursion(String str) {
        if(str.isEmpty() || str==null) {
            return str;
        }
        
        return reverseRecursion(str.substring(1)) + str.charAt(0);
    }

    private char[] reverseRecursionArr(char[] s, int start, int end) {
        if(s == null || start >= end ) {
            return s;
        }
        char tmp = s[end];
        s[end] = s[start];
        s[start] = tmp;
        return reverseRecursionArr(s, start+1, end-1); 
    }

    private String reverseLoop(String str) {
        char[] newStr = str.toCharArray();
        
        for(int i=0; i<str.length()/2; i++) {
            char tmp = newStr[i];
            newStr[i] = newStr[str.length()-1-i];
            newStr[str.length()-1-i] = tmp;
        }
        return new String(newStr);
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