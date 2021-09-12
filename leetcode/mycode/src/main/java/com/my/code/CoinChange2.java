package com.my.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CoinChange2 {

    public void callSolution(int coins[], int amount) {
        Solution sln = new Solution();
        int total = sln.coinChange2(coins, amount);
        System.out.println(total);
    }

    class Solution {
        public int coinChange2(int[] coins, int amount) {

            int dp[] = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i >= coins[j]) {
                        int substract = i - coins[j];
                        dp[i] = Math.min(dp[substract] + 1, dp[i]);
                    }
                }
            }

            return dp[amount] < amount + 1 ? dp[amount] : -1;
        }
    }
}
