package com.my.code;

import java.util.HashMap;
import java.util.Map;

public class RomanNumber {
    public RomanNumber() {
        
    }

    public int callSolution(String s) {
        Solution sln = new Solution();
        return sln.romanToInt(s);
    }

    class Solution {
        public int romanToInt(String s) {
            Map<String,Integer> m = new HashMap<String,Integer>();
            m.put("I", 1);
            m.put("V", 5);
            m.put("X", 10);
            m.put("L", 50);
            m.put("C", 100);
            m.put("D", 500);
            m.put("M", 1000);

            m.put("IV", 4);
            m.put("IX", 9);
            m.put("XL", 40);
            m.put("XC", 90);
            m.put("CD", 400);
            m.put("CM", 900);

            if(m.get(s) != null) {
                return m.get(s);
            }

            int val = 0;
            char[] strX = s.toCharArray();
            int i = 0;
            while(i<s.length()) {
                String x = null;
                if(i+1 < s.length()) {
                    x = strX[i]+ "" +strX[i+1];
                }
                if(m.get(x) != null) {
                    val += m.get(x);
                    i+=2;
                }else {
                    x = strX[i]+ "";
                    val += m.get(x);
                    i+=1;
                }
                
            }

            return val;            
        }
    }
}


