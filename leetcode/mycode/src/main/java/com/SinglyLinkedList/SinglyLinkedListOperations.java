package com.SinglyLinkedList;

public class SinglyLinkedListOperations {

    public SinglyLinkedListNode mergeList(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) {
            return head1;
        }
        if (head1 != null && head2 == null) {
            return head1;
        }
        if (head1 == null && head2 != null) {
            return head2;
        }
        if (head1.data > head2.data) {
            SinglyLinkedListNode t = head1;
            head1 = head2;
            head2 = t;
        }
        SinglyLinkedListNode newhead = head1;
        SinglyLinkedListNode prev = head1;

        while (head1 != null && head2 != null) {
            if (head1.data > head2.data) {
                SinglyLinkedListNode t2 = head2.next;
                prev.next = head2;
                head2.next = head1;
                prev = prev.next;
                head2 = t2;
            } else if (head1.data < head2.data) {
                prev = head1;
                head1 = head1.next;
            } else {
                SinglyLinkedListNode t1 = head1.next;
                SinglyLinkedListNode t2 = head2.next;
                prev = head2;
                head1.next = head2;
                head2.next = t1;
                head1 = t1;
                head2 = t2;
            }
        }

        if (head2 != null) {
            prev.next = head2;
        }

        return newhead;
    }
}
