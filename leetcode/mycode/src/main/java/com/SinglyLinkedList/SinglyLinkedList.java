package com.SinglyLinkedList;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int v) {
        this.data = v;
    }
}

public class SinglyLinkedList {

    public SinglyLinkedListNode makeFromArray(int[] arr) {
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode curr = null;

        for (int i = 0; i < arr.length; i++) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(arr[i]);
            if (curr == null) {
                curr = node;
            } else {
                curr.next = node;
                curr = curr.next;
            }
            if (head == null) {
                head = curr;
            }
        }

        return head;
    }

}
