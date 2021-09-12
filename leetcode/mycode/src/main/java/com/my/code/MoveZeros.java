package com.my.code;

public class MoveZeros {
    public void callSolution(int[] nums) {
        Solution sln = new Solution();
        sln.moveZeroes(nums);
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int end = nums.length -1;
            int start = 0;
            while(nums[end] == 0 && end > 0) {
                end--;
            }
            while(start < end) {
                int shift = 0;
                while(nums[start] == 0 && start <= end){
                    start++;
                    shift++;
                }
                
                if(shift == 0) {
                    start++;
                } else {
                    int start2 = start;
                    while(start2 <=end) {
                        nums[start2-shift] = nums[start2++];
                    }
                    while(shift > 0 && end < nums.length) {
                        nums[end] = 0;
                        end--;
                        start--;
                        shift--;
                    }
                }
                
            }
        }
        public void moveZeroesAndSort(int[] nums) {
            int end = nums.length - 1;
            while(nums[end] == 0 && end > 0) {
                end--;
            }
            for(int k=end; k>0; k--) {
                for(int i=0; i<k; i++) {
                    if(nums[i] == 0) {
                        int tmp = nums[k];
                        nums[k] = nums[i];
                        nums[i] = tmp;
                        while(nums[end] == 0 && end > 0) {
                            end--;
                            k--;
                        }
                    } 
                    if(nums[i+1] == 0 && nums[k] != 0 && k>i+1) {
                        int tmp = nums[k];
                        nums[k] = nums[i+1];
                        nums[i+1] = tmp;
                        while(nums[end] == 0 && end > 0) {
                            end--;
                            k--;
                        }
                    } 
                    if(nums[i] > nums[i+1] && nums[i+1] != 0) {
                        int tmp = nums[i];
                        nums[i] = nums[i+1];
                        nums[i+1] = tmp;
                    }
                }
            }            
        }
    }
}
