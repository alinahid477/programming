package com.my.code;

public class LongestPalindromicSubstring {

    public void callSolution(String s) {
        Solution sln = new Solution();
        System.out.println(sln.longestPalindrome(s));
    }

    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || 1 > s.length() || s.length() > 1000) {
                return null;
            }
            if (isPalindrom(s)) {
                return s;
            }
            if (s.length() == 1) {
                return s;
            }
            if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
                return s;
            }
            if (s.length() == 2 && s.charAt(0) != s.charAt(1)) {
                return s.charAt(0) + "";
            }
            String rs = new StringBuilder(s).reverse().toString();

            return longestSubstring2(s, rs);
        }

        public String longestCommonSubstring(String s1, String s2) {
            int max = Integer.MIN_VALUE;
            int maxi = 0, maxj = 0;
            int[][] arr = new int[s1.length() + 1][s2.length() + 1];
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 0;
                    } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                        if (arr[i][j] > max) {
                            max = arr[i][j];
                            maxi = i;
                            maxj = j;
                        }
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }

            String s = "";
            int i = maxi, j = maxj;
            while (arr[i][j] != 0) {
                s += s1.charAt(i - 1);
                i--;
                j--;
            }
            return s;
        }

        public String longestSubstring2(String s, String t) {
            int n = s.length(), maxLen = 0, to = 0;
            int[] dp = new int[n + 1];
            for (int i = 0; i < n; i++) {
                char ch1 = s.charAt(i);
                for (int j = n; j > 0; j--) {
                    char ch2 = t.charAt(j - 1);
                    if (ch1 == ch2) {
                        dp[j] = dp[j - 1] + 1;
                        if (maxLen <= dp[j]) {
                            maxLen = dp[j];
                            to = j;
                        }
                    } else {
                        dp[j] = 0;
                    }
                }
            }
            return t.substring(to - maxLen, to);
        }

        public boolean isPalindrom(String s) {
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
