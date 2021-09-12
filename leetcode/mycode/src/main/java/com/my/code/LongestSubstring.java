package com.my.code;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    
    public LongestSubstring() {
        
    }


    public void callSolution(String s) {
        Solution sln = new Solution();
        System.out.println(sln.lengthOfLongestSubstring(s));
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() > 49999) {
                return -1;
            }
            // if(s.isEmpty()) {
            //     return 0;
            // }
            int max = Integer.MIN_VALUE;
            int n = s.length();
            if(n == 0) {
                return 0;
            }
            Set<Character> visited = new HashSet<>();
            int i=0,j=0;
            while(i<n && j<n) {
                if(!visited.contains(s.charAt(j))) {
                    visited.add(s.charAt(j++));
                    if(visited.size() > max) {
                        max = visited.size();
                    }
                } else {
                    visited.remove(s.charAt(i++));
                }
                
            }
            return max;       
        }
    }
}
