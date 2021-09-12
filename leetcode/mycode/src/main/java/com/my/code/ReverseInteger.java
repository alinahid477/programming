package com.my.code;

public class ReverseInteger {
    public ReverseInteger() {
        
    }

    public int callSolution(int x) {
        Solution sln = new Solution();
        return sln.reverse(x);
    }

    class Solution {
        public int reverse(int x) {
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            boolean isNeg = false;
            if(x < 0) {
                isNeg = true;
                x = x * -1;
            }
            int rev = 0;
            
            while(x != 0) {
                int tmp  = x%10;
                x = x/10;
                if (rev > Integer.MAX_VALUE/10) {
                    return 0;
                }
                rev = rev*10 + tmp;
            }
            //rev = rev*10 + x;
            if(isNeg) {
                rev = rev * -1;
            }
            
            return rev;
        }
    }
}


