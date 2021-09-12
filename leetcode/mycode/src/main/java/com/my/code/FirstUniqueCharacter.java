package com.my.code;

import java.util.Map;
import java.util.HashMap;

public class FirstUniqueCharacter {
    public int callSolution(String s) {
        Solution sln = new Solution();
        return sln.firstUniqChar(s);
    }

    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();
            
            for(int i=0; i<s.length();i++) {
                if(map.containsKey(s.charAt(i))) {
                   map.put(s.charAt(i), -1);                 
                } else {
                    map.put(s.charAt(i), i);
                }
            }
            java.util.Optional<java.util.Map.Entry<Character,Integer>> found = map.entrySet().stream().filter(entry->entry.getValue() > -1).sorted((a,b)->a.getValue().compareTo(b.getValue())).findFirst();
            if(!found.isEmpty()) {
                return found.get().getValue();
            }
            return -1;
        }
    }
}
