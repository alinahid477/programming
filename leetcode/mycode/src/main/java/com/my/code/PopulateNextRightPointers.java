package com.my.code;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulateNextRightPointers {

    public void callSolution(int[] input) {
        Node root = null;
        Queue<Node> q = new LinkedList<>();
        Node n = new Node(input[0]);
        if (root == null) {
            root = n;
            q.add(n);
        }
        for (int i = 1; i < input.length; i++) {
            Node parent = q.poll();
            parent.left = new Node(input[i++]);
            q.add(parent.left);
            parent.right = new Node(input[i]);
            q.add(parent.right);
        }

        Solution sln = new Solution();
        sln.connect(root);
    }

    class Solution {
        public Node connect(Node root) {

            if (root == null) {
                return null;
            }

            int level = 0;

            Queue<Node> q = new LinkedList<>();

            Node curr = root;
            curr.next = null;
            q.add(curr);

            while (q.size() != 0) {

                int len = (int) Math.pow(2, level);
                int nodelen = (int) Math.pow(2, level + 1);
                Node[] n = new Node[nodelen];
                int idx = 0;
                for (int i = 0; i < len; i++) {
                    Node x = q.poll();
                    if (x == null || x.left == null || x.right == null) {
                        continue;
                    }
                    n[idx++] = x.left;
                    q.add(x.left);
                    n[idx++] = x.right;
                    q.add(x.right);
                }
                if (n[0] != null) {
                    makeConnections(n);
                }

                level += 1;
            }

            return root;
        }

        public void makeConnections(Node[] n) {
            int i = 0;
            for (i = 0; i < n.length - 1; i++) {
                n[i].next = n[i + 1];
            }
            n[i].next = null;
        }

    }
}
