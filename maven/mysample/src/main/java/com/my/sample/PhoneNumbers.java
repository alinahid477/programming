package com.my.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PhoneNumbers {

    Map<Integer, String> map = new HashMap<>();


    public void print(int[] nums) {
        List<String> l = gen(nums, 0, new char[nums.length], 0, new ArrayList<String>());
        for(String x: l) {
            System.out.print(x + ",");
        }
    }

    public void init() {
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public List<String> gen(int[] nums, int idx, char[] str, int cdx, List<String> l) {
        if(idx == nums.length) {
            l.add(new String(str));
            return l;
        }

        for(int i=0; i<map.get(nums[idx]).toCharArray().length; i++) {
            str[cdx++]= map.get(nums[idx]).toCharArray()[i];
            gen(nums,idx+1,str, cdx, l);
            cdx--;
        }

        return l;
    }


    
}