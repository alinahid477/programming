package com.my.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

public class MergeIntervals {

    public void callSolution(int[][] intervals) {
        Solution sln = new Solution();
        int[][] res = sln.merge(intervals);
        System.out.println("[");
        for (int[] r : res) {
            System.out.print("[");
            for (int i = 0; i < r.length - 1; i++) {
                System.out.print(r[i] + ",");
            }
            System.out.print(r[r.length - 1] + "],");
        }
        System.out.println("]");
    }

    class SortByPair implements Comparator<int[]> {

        @Override
        public int compare(int[] p1, int[] p2) {
            return p1[0] - p2[0];
        }
    }

    class Solution {

        public int[][] merge(int[][] intervals) {

            if (intervals.length == 1) {
                return intervals;
            }

            java.util.Set<int[]> l = new java.util.HashSet<>();
            boolean isLastIntervalMerged = false;
            Arrays.sort(intervals, new SortByPair());

            for (int i = 0; i < intervals.length - 1; i++) {
                int[] merged = new int[] { intervals[i][0], -1 };
                if (intervals[i][1] < intervals[i + 1][0]) {
                    merged[1] = intervals[i][1];
                    l.add(merged);
                    continue;
                }
                int j = i + 1;
                while (j < intervals.length && intervals[i][1] >= intervals[j][0]) {
                    merged[1] = Math.max(intervals[i][1], intervals[j][1]);
                    j++;
                }
                l.add(merged);
                i = j - 1;
            }

            if (intervals[intervals.length - 2][1] >= intervals[intervals.length - 1][0]) {
                
            }

            int[][] array = new int[l.size()][2];
            l.toArray(array);
            return array;
        }
    }

}
