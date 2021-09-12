package com.my.code;

import java.util.Map;
import java.util.HashMap;

public class MaxDistanceBlock {

    class Block {
        public Map<String, Boolean> data = new HashMap<>();
    }

    public void callSolution() {
        Block[] blocks = new Block[5];
        blocks[0] = new Block();
        blocks[0].data.put("gym", false);
        blocks[0].data.put("school", true);
        blocks[0].data.put("store", false);

        blocks[1] = new Block();
        blocks[1].data.put("gym", true);
        blocks[1].data.put("school", false);
        blocks[1].data.put("store", false);

        blocks[2] = new Block();
        blocks[2].data.put("gym", true);
        blocks[2].data.put("school", true);
        blocks[2].data.put("store", false);

        blocks[3] = new Block();
        blocks[3].data.put("gym", false);
        blocks[3].data.put("school", true);
        blocks[3].data.put("store", false);

        blocks[4] = new Block();
        blocks[4].data.put("gym", false);
        blocks[4].data.put("school", true);
        blocks[4].data.put("store", true);

        String[] reqs = new String[] { "gym", "school", "store" };

        MaxDistanceBlockFind mdbf = new MaxDistanceBlockFind();
        mdbf.findMaxDistanceBlock(blocks, reqs);
    }

    class MaxDistanceBlockFind {
        public int findMaxDistanceBlock(Block[] blocks, String[] reqs) {

            int maxDist = Integer.MAX_VALUE;
            int minIdx = blocks.length;

            for (int i = 0; i < blocks.length; i++) {
                int[] dist = new int[reqs.length];
                for (int j = 0; j < reqs.length; j++) {
                    int lDist = travelLeft(i, blocks, reqs[j]);
                    int rDist = travelRight(i, blocks, reqs[j]);
                    dist[j] = Math.min(lDist, rDist);
                }
                int totalDist = 0;
                for (int d : dist) {
                    totalDist += d;
                }

                if (maxDist > totalDist) {
                    minIdx = i;
                    maxDist = totalDist;
                }
            }

            return minIdx;
        }

        public int travelRight(int idx, Block[] blocks, String req) {
            int dist = 0;
            while (idx < blocks.length) {
                if (blocks[idx].data.get(req)) {
                    return dist;
                }
                dist += 1;
                idx += 1;
            }
            return Integer.MAX_VALUE;
        }

        public int travelLeft(int idx, Block[] blocks, String req) {
            int dist = 0;
            while (idx >= 0) {
                if (blocks[idx].data.get(req)) {
                    return dist;
                }
                dist += 1;
                idx -= 1;
            }
            return Integer.MAX_VALUE;
        }

    }
}
