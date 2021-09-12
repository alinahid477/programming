package com.my.code;

import java.util.Arrays;

public class CoinChange {

    public void callSolution(int coins[], int amount) {
        Solution sln = new Solution();
        int total = sln.coinChange(coins, amount);
        System.out.println(total);
    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            // F(S) = F(S - C) + 1;
            // F(0) = 0;
            // F(1) =
            // [3, 5, 6, 7], 5
            // [2], 5
            if (amount == 0) {
                return 0;
            }
            Arrays.sort(coins);

            int len = coins.length;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);

            dp[0] = 0;

            if (coins[0] <= amount) {
                dp[coins[0]] = 1; // dp[2] = 1;
            } else {
                return -1;
            }
            int i = coins[0] + 1; // 3

            while (i <= amount) {
                int remainder = 0;
                for (int c = 0; c < len; c++) {
                    if (coins[c] <= i) {
                        remainder = i - coins[c];
                        int coinCountForRemainder = dp[remainder];
                        dp[i] = Math.min(dp[i], coinCountForRemainder + 1);
                        // dp[3] = 1
                        // dp[4] = 2
                        // dp[5] = 1+dp[3] = 1 + 1 = 2
                    } else {
                        break;
                    }
                }
                i++;
            }

            return dp[amount] > amount + 1 ? -1 : dp[amount];
        }
    }
}
