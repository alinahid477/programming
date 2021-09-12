package com.my.code;

public class FindPeakElement {

    public void callSolution(int[] nums) {
        Solution sln = new Solution();
        int x = sln.findPeakElement(nums);
        System.out.println(x);
    }

    class Solution {

        public int findPeakElement(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            if (nums.length < 3) {
                if (nums[0] > nums[1]) {
                    return 0;
                }
                return 1;
            }

            int i = 1;
            while (i < nums.length - 1) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
                i++;
            }

            return nums.length - 1;
        }
    }

}
