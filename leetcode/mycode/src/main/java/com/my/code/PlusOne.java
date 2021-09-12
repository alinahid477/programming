package com.my.code;

import java.util.Stack;

public class PlusOne {
    public int[] callSolution(int[] digits) {
        Solution sln = new Solution();
        return sln.plusOne(digits);
    }

    class Solution {
        public int[] plusOne(int[] digits) {
            
            Stack<Integer> s = new Stack<Integer>();

            int end = digits.length -1;
            boolean isCarry = false;
            while(end > -1) {
                if(end == digits.length -1) {
                    isCarry = true;
                }
                int digit = digits[end];
                
                if(isCarry) {
                    digit += 1;
                }
                if(digit > 9) {
                    isCarry = true;
                    s.push(0);
                } else {
                    isCarry = false;
                    s.push(digit);
                }
                end--;
            }
            if(isCarry) {
                s.push(1);
            }
            int i=0;
            int ret[] = new int[s.size()];
            while(!s.empty()) {
                ret[i++] = s.pop();
            }
            return ret;
        }
    }
}
