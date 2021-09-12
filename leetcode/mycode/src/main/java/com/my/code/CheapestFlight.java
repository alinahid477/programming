package com.my.code;

import java.util.*;

public class CheapestFlight {

    public void callSolution(int n, int[][] flights, int src, int dst, int K) {
        Solution sln = new Solution();
        int cost = sln.findCheapestPrice(n, flights, src, dst, K);
        System.out.println(cost);

    }

    class Solution {

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

            int[][] map = new int[n][n];

            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];
                map[s][d] = p;
            }

            if (K == 0) {
                for (int d = 0; d < map[src].length; d++) {
                    if (map[src][d] > 0 && d == dst) {
                        return map[src][d];
                    }
                }
                return -1;
            }

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] { src, 0, 0 });
            Map<Integer, Integer> costMap = new HashMap<>();

            int minCost = Integer.MAX_VALUE;

            while (q.size() != 0) {
                int[] qv = q.poll();
                int s = qv[0];
                int p = qv[1];
                int c = qv[2];
                if (s == dst) {
                    minCost = Math.min(p, minCost);
                    continue;
                }
                if (map[s].length < 1) {
                    continue;
                }
                for (int d = 0; d < map[s].length; d++) {
                    if (map[s][d] < 1) {
                        continue;
                    }
                    int currCost = map[s][d] + p;
                    int currCount = c + 1;
                    int prevCost = costMap.getOrDefault(d, Integer.MAX_VALUE);

                    if (prevCost > currCost && K >= currCount - 1) {
                        q.add(new int[] { d, currCost, currCount });
                        costMap.put(d, currCost);
                    }
                }
            }

            return minCost == Integer.MAX_VALUE ? -1 : minCost;
        }

        public Map<Integer, List<int[]>> mapNodes(int[][] flights) {
            Map<Integer, List<int[]>> map = new HashMap<>();

            for (int i = 0; i < flights.length; i++) {
                int src = flights[i][0];
                if (!map.containsKey(src)) {
                    List<int[]> l = new ArrayList<>();
                    for (int j = 0; j < flights.length; j++) {
                        if (src == flights[j][0]) {
                            l.add(new int[] { flights[j][0], flights[j][1], flights[j][2] });
                        }
                    }
                    map.put(src, l);
                }
            }
            return map;
        }

        public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {

            LinkedList<Integer> q = new LinkedList<>();
            Map<Integer, List<int[]>> map = mapNodes(flights);
            if (map.containsKey(src)) {
                q.add(src);
            } else {
                return -1;
            }

            if (K == 0) {
                List<int[]> lflights = map.get(src);
                for (int[] f : lflights) {
                    if (f[1] == dst) {
                        return f[2];
                    }
                }
                return -1;
            }

            int minCost = Integer.MAX_VALUE;

            Map<String, int[]> costMap = new HashMap<>();
            Set<Integer> seen = new HashSet<>();

            while (q.size() != 0) {
                int s = q.poll();
                if (s == dst) {
                    int[] tt = costMap.get(src + "+" + dst);
                    if (tt != null && minCost > tt[0]) {
                        minCost = tt[0];
                    }
                    continue;
                }

                List<int[]> lflights = map.get(s);
                if (lflights == null) {
                    continue;
                }
                int t[] = costMap.get(src + "+" + s);
                int residualCost = 0;
                int residualCount = 0;
                if (t != null) {
                    residualCount = t[1] + 1;
                    residualCost = t[0];
                }
                if (residualCount - 2 > K) {
                    continue;
                }
                for (int[] f : lflights) {

                    int d = f[1];
                    int cost = f[2] + residualCost;

                    if (residualCost > 0 && f[2] > residualCost) {
                        continue;
                    }

                    int cnt = residualCount + 1;

                    if (!seen.contains(d)) {
                        q.add(d);
                        seen.add(d);
                    }

                    int[] tx = costMap.get(src + "+" + d);

                    if (tx != null) {
                        if (cost > tx[0]) {
                            cnt = tx[1];
                        }
                        cost = Math.min(tx[0], cost);
                    }
                    costMap.put(src + "+" + d, new int[] { cost, cnt });
                }
            }
            return minCost == Integer.MAX_VALUE ? -1 : minCost;
        }
    }
}
