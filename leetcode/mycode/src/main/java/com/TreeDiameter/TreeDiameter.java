package com.TreeDiameter;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TreeDiameter {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br =
        // new BufferedReader(new InputStreamReader(System.in));

        // int t = Integer.parseInt(br.readLine());

        // while (t > 0) {
        // String s = br.readLine();
        // Node root = buildTree(s);
        // Tree g = new Tree();
        // System.out.println(g.diameter(root));
        // t--;
        // }

        // String s = "1 2 3 N N 4 6 N 5 N N 7 N";
        // String s = "1 2 3 4 5 N 6 N N 7 8 N 9 N N N N 10 11 12 13 N N";
        String s = "1 3 2 N N 5 4 N N N N";
        Node root = buildTree(s);
        Tree g = new Tree();
        int diameter = g.diameter(root);
        System.out.println(diameter);
        g.doPrint(root);
    }
}

class Tree {
    /* Complete the function to get diameter of a binary tree */

    void doPrint(Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.print(node.data);
            return;
        }
        doPrint(node.left);
        System.out.print(node.data);
        doPrint(node.right);
    }

    int diameter(Node root) {
        // Your code here

        if (root == null) {
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);
        return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return 1 + Math.max(lh, rh);
    }

}