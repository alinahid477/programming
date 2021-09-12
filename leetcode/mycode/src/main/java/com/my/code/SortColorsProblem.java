package com.my.code;

public class SortColorsProblem {

    public void callSolution(int[] nums) {
        Solution sln = new Solution();
        sln.sortColors(nums);
    }

    class Solution {
        public void sortColors(int[] nums) {

            int redP = 0;
            int blueP = nums.length - 1;
            int i = 0;
            while (i <= blueP && blueP > redP) {
                if (nums[i] == 0) {
                    int tmp = nums[i];
                    nums[i] = nums[redP];
                    nums[redP] = tmp;
                    i++;
                    redP++;
                } else if (nums[i] == 2) {
                    int tmp = nums[i];
                    nums[i] = nums[blueP];
                    nums[blueP] = tmp;
                    blueP--;
                } else {
                    i++;
                }

            }

            System.out.print("[");
            for (i = 0; i < nums.length - 1; i++) {
                System.out.print(nums[i] + ",");
            }
            System.out.println(nums[nums.length - 1] + "]");
        }
    }
}
