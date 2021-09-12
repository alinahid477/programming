package com.my.code;

public class FirstLastElementPosition {

    public void callSolution(int[] nums, int target) {
        Solution sln = new Solution();
        int[] x = sln.searchRange(nums, target);
        System.out.println("[" + x[0] + "," + x[1] + "]");
    }

    class Solution {

        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[] { -1, -1 };
            if (nums.length < 1) {
                return res;
            }
            if (nums.length == 1 && nums[0] == target) {
                return new int[] { 0, 0 };
            }
            int start = -1, end = -1;

            int hi = nums.length - 1, lo = 0, mid = -1;

            while (lo < hi - 1) {
                mid = lo + ((hi - lo) / 2);
                if (target < nums[mid]) {
                    hi = mid;
                } else if (target > nums[mid]) {
                    lo = mid;
                } else {
                    start = mid;
                    end = start;
                    break;
                }

            }

            if (start == -1 && nums[lo] == target) {
                start = lo;
            }
            if (end == -1 && nums[hi] == target) {
                end = hi;
            }

            while (start > 0 && nums[start - 1] == target) {
                start--;
            }

            while (end < nums.length - 1 && nums[end + 1] == target) {
                end++;
            }
            if (start == -1 && end > -1) {
                start = end;
            }
            if (end == -1 && start > -1) {
                end = start;
            }
            return new int[] { start, end };
        }
    }

}
