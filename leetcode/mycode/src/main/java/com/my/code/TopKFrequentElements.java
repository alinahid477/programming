package com.my.code;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.security.KeyStore.Entry;
import java.util.Collection;
import java.util.HashMap;

public class TopKFrequentElements {

    public void callSolution(int[] nums, int k) {
        Solution sln = new Solution();
        int[] res = sln.topKFrequent(nums, k);
        System.out.print("[");
        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + ",");
        }
        System.out.println(res[res.length - 1] + "]");
    }

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    int val = map.get(nums[i]) + 1;
                    map.put(nums[i], val);
                } else {
                    map.put(nums[i], 1);
                }
            }

            Iterator<java.util.Map.Entry<Integer, Integer>> itr = map.entrySet().stream()
                    .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue())).iterator();

            int x[] = new int[k];
            int i = 0;
            // Iterator<java.util.Map.Entry<Integer, Integer>> itr = set.iterator();
            while (itr.hasNext() && i < k) {
                x[i] = itr.next().getKey();
                i++;
            }

            return x;
        }
    }
}
