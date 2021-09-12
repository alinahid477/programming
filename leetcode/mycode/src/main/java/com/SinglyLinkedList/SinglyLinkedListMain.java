package com.SinglyLinkedList;

public class SinglyLinkedListMain {
    public static void main(String[] argv) {
        SinglyLinkedList sll = new SinglyLinkedList();
        SinglyLinkedListNode head1 = sll.makeFromArray(new int[] { 4, 5, 6 });
        SinglyLinkedListNode head2 = sll.makeFromArray(new int[] { 1, 2, 10 });

        SinglyLinkedListOperations ops = new SinglyLinkedListOperations();
        ops.mergeList(head1, head2);
    }
}
