package com.my.code;

public class ShiftArraySearch {
    public int callSolution(int[] nums, int target) {
        Solution sln = new Solution();
        return sln.search(nums, target);
    }

    class Solution {
        public int search(int[] nums, int target) {

            if (nums.length == 1) {
                if (nums[0] == target) {
                    return 0;
                } else {
                    return -1;
                }
            } else if (nums.length == 2) {
                if (nums[0] == target) {
                    return 0;
                } else if (nums[1] == target) {
                    return 1;
                } else {
                    return -1;
                }
            }

            int pivot = findPivot(nums);
            int idx = findNum(nums, target, 0, pivot);
            if (idx == -1) {
                idx = findNum(nums, target, pivot, nums.length - 1);
            }

            return idx;
        }

        public int findNum(int[] nums, int target, int s, int e) {
            int start = s;
            int end = e;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return -1;
        }

        public int findPivot(int[] nums) {

            if (nums[0] < nums[nums.length - 1]) {
                return 0;
            }

            int start = 0;
            int end = nums.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if ((mid == 0 && nums[mid] < nums[end]) || (mid > 0 && nums[mid] < nums[mid - 1])) {
                    return mid;
                }

                if (nums[mid] > nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return 0;
        }
    }
}