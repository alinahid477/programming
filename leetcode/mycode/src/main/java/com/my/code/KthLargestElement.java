package com.my.code;

import java.util.PriorityQueue;

public class KthLargestElement {

    public void callSolution(int[] nums, int k) {
        Solution sln = new Solution();
        int x = sln.findKthLargest(nums, k);
        System.out.println(x);
    }

    class Solution {

        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < nums.length; i++) {
                pq.add(nums[i]);
                if (pq.size() > k) {
                    pq.remove();
                }
            }

            return pq.remove();
        }
    }

}
