package com.my.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class KthSmallest {

    public void callSolution(Integer[] input, int k) {
        TreeNode root = null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode n = new TreeNode(input[0]);
        if (root == null) {
            root = n;
            q.add(n);
        }
        for (int i = 1; i < input.length; i++) {
            TreeNode parent = q.poll();
            if (i < input.length) {
                if (input[i] != null) {
                    parent.left = new TreeNode(input[i]);
                    q.add(parent.left);
                }
                i++;
            }
            if (i < input.length) {
                if (input[i] != null) {
                    parent.right = new TreeNode(input[i]);
                    q.add(parent.right);
                }

            }

        }

        Solution sln = new Solution();
        sln.kthSmallest(root, k);
    }

    class Solution {

        public List<TreeNode> travel(TreeNode root, List<TreeNode> arr) {
            if (root == null) {
                return arr;
            }

            travel(root.left, arr);
            arr.add(root);
            travel(root.right, arr);

            return arr;

        }

        public int kthSmallest(TreeNode root, int k) {
            List<TreeNode> tree = travel(root, new ArrayList<TreeNode>());
            return tree.get(k - 1).val;
        }
    }
}
