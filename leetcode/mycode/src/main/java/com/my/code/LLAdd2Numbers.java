package com.my.code;

public class LLAdd2Numbers {

    public void callSolution(int[] n1, int[] n2) {

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

        ListNode head2 = null;
        cur = null;
        for (int i = 0; i < n2.length; i++) {
            if (head2 == null) {
                head2 = new ListNode(n2[i]);
                cur = head2;
            } else {
                ListNode ln = new ListNode(n2[i]);
                cur.next = ln;
                cur = ln;
            }
        }

        Solution sln = new Solution();
        ListNode ln = sln.addTwoNumbers(head1, head2);
        System.out.print("[");
        while (ln != null) {
            if (ln.next != null) {
                System.out.print(ln.val + ",");
            } else {
                System.out.print(ln.val);
            }

            ln = ln.next;
        }
        System.out.println("]");

    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode resCurr = null;
            ListNode resHead = null;

            int carry = 0;
            while (l1 != null || l2 != null) {
                int n1 = 0, n2 = 0;
                if (l1 != null) {
                    n1 = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    n2 = l2.val;
                    l2 = l2.next;
                }
                int sum = carry + n1 + n2;
                carry = sum / 10;
                ListNode ln = new ListNode(sum % 10);
                if (resHead == null) {
                    resHead = ln;
                    resCurr = resHead;
                } else {
                    resCurr.next = ln;
                    resCurr = ln;
                }
            }
            if (carry > 0) {
                ListNode ln = new ListNode(carry);
                if (resHead == null) {
                    resHead = ln;
                    resCurr = resHead;
                } else {
                    resCurr.next = ln;
                    resCurr = ln;
                }
            }

            return resHead;
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
