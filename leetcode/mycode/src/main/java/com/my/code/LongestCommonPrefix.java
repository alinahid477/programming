package com.my.code;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
    public LongestCommonPrefix() {
        
    }

    public String callSolution(String[] strs) {
        Solution sln = new Solution();
        return sln.longestCommonPrefix(strs);
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            
            if(strs.length == 0){
                return "";
            }

            String common = "";
            for(int i=0;i<strs[0].length();i++) {
                char c = strs[0].charAt(i);

                for(int s=1;s<strs.length; s++) {
                    if(strs[s].length() <= i) {
                        return common;
                    }
                    if(strs[s].charAt(i) != c) {
                        return common;
                    } 
                    
                }
                common += c;
            }

            return common;
        }
    }
}


