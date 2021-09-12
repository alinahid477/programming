package com.my.code;

public class PalindromInteger {
    public PalindromInteger() {
        
    }

    public boolean callSolution(int x) {
        Solution sln = new Solution();
        return sln.isPalindrome(x);
    }

    class Solution {
        public boolean isPalindrome(int x) {
            if (x == Integer.MIN_VALUE) {
                return false;
            }
            if(x < 0) {
                return false;
            }
            if(x<10) {
                return true;
            }
            int orig = x;
            int rev = getReversedStr(x);
            return rev == orig;
        }

        private int getReversedStr(int x) {
            String strX = x+"";
            int start = 0;
            int end = strX.length() -1;
            while(start < end) {
                if(strX.charAt(start) !=  strX.charAt(end)) {
                    return 0;
                }
                start++;
                end--;
            }
            return x;
        }

        private int getReversed(int x) {
            int rev = 0;
            
            while(x != 0) {
                int tmp  = x%10;
                x = x/10;
                rev = rev*10 + tmp;
            }

            return rev;
        }
    }
}


