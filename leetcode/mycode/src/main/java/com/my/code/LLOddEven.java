package com.my.code;

public class LLOddEven {

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
        ListNode ln = sln.oddEvenList(head1);
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

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = head.next;

            while (odd.next != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;

                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
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

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
