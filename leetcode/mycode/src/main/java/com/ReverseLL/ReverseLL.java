package com.ReverseLL;

public class ReverseLL {
    // c n
    // 1<->2 3->4->NULL
    // 4->3->2->1->NULL
    // animation: https://www.geeksforgeeks.org/reverse-a-linked-list/
    public static void main(String[] argv) {
        ReverseLL rll = new ReverseLL();
        rll.callSolution(new int[] { 1, 2, 3, 4 });
    }

    class Solution {
        public ListNode reverse(ListNode head) {

            ListNode curr = head;
            ListNode prev = null;
            ListNode next = null;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public void callSolution(int[] n1) {

        ListNode head1 = null;
        ListNode cur = null;
        for (int i = 0; i < n1.length; i++) {
            if (head1 == null) {
                head1 = new ListNode(n1[i]);
                cur = head1;
            } else {
                ListNode ln = new ListNode(n1[i]);
                cur.next = ln;
                cur = ln;
            }
        }

        Solution sln = new Solution();
        ListNode ln = sln.reverse(head1);
        System.out.print("[");
        while (ln != null) {
            if (ln.next != null) {
                System.out.print(ln.val + "->");
            } else {
                System.out.print(ln.val);
            }

            ln = ln.next;
        }
        System.out.println("]");

    }
}
