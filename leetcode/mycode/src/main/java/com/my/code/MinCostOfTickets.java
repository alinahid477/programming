package com.my.code;

import java.util.Arrays;

public class MinCostOfTickets {
    public void callSolution(int[] days, int[] costs) {
        Solution sln = new Solution();
        int total = sln.mincostTickets(days, costs);
        System.out.println(total);
    }

    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int dp[][] = new int[3][days.length];

            dp[0][0] = costs[0];

            // 1 day pass
            for (int i = 1; i < days.length; i++) {
                dp[0][i] = dp[0][i - 1] + costs[0];
            }

            Arrays.fill(dp[1], 1001);
            Arrays.fill(dp[2], 1001);

            // 30 days
            int startIndex = 0;
            int residualCost = 0;
            int daysToCover = days[startIndex] + 6;
            while (startIndex < days.length) {
                while (startIndex < days.length) {
                    int i = startIndex;

                    if (days[i] <= daysToCover) {
                        if (residualCost + costs[1] < dp[0][i]) {
                            dp[1][i] = residualCost + costs[1];
                        } else {
                            dp[1][i] = dp[0][i];
                        }
                    } else {
                        residualCost = dp[1][i - 1];
                        daysToCover = days[i] + 6;
                        break;
                    }
                    startIndex += 1;
                }

            }

            startIndex = 0;
            residualCost = 0;
            daysToCover = days[startIndex] + 29;
            while (startIndex < days.length) {

                while (startIndex < days.length) {
                    int i = startIndex;

                    if (days[i] <= daysToCover) {
                        if (residualCost + costs[2] < dp[1][i]) {
                            dp[2][i] = residualCost + costs[2];
                        } else {
                            dp[2][i] = dp[1][i];
                        }
                    } else {
                        residualCost = dp[2][i - 1];
                        daysToCover = days[i] + 29;
                        break;
                    }
                    startIndex += 1;
                }
            }

            return dp[2][days.length - 1];
        }
    }
}
