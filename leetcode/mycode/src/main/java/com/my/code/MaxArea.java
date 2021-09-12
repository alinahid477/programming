package com.my.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxArea {

    public void callSolution(int[][] grid) {
        Solution sln = new Solution();
        int maxArea = sln.findMaxArea(grid);
        System.out.println(maxArea);

    }

    class Solution {
        public int findMaxArea(int[][] grid) {
            // Code here
            Queue<int[]> q = new LinkedList<>();

            int row = grid.length;
            int col = grid[0].length;
            int[][] visited = new int[row][col];
            int maxCount = 0;
            for (int i = 0; i < row; i++) {
                boolean broken = false;
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        q.add(new int[] { i, j });
                        visited[i][j] = 1;
                        maxCount = 1;
                        broken = true;
                        break;
                    }
                }
                if (broken) {
                    break;
                }
            }

            while (q.size() != 0) {
                int[] node = (int[]) q.poll();
                int i = node[0];
                int j = node[1];
                int count = visited[i][j];
                while (i >= 0 && j >= 0 && i < row && j < col) {

                    if (j + 1 < col && grid[i][j + 1] == 1 && visited[i][j + 1] == 0) {
                        count += 1;
                        j += 1;
                        visited[i][j] = count;
                        q.add(new int[] { i, j });
                    } else if (j - 1 >= 0 && grid[i][j - 1] == 1 && visited[i][j - 1] == 0) {
                        count += 1;
                        j -= 1;
                        visited[i][j] = count;
                        q.add(new int[] { i, j });
                    } else if (i + 1 < row && grid[i + 1][j] == 1 && visited[i + 1][j] == 0) {
                        count += 1;
                        i += 1;
                        visited[i][j] = count;
                        q.add(new int[] { i, j });
                    } else if (i - 1 >= 0 && grid[i - 1][j] == 1 && visited[i - 1][j] == 0) {
                        count += 1;
                        i -= 1;
                        visited[i][j] = count;
                        q.add(new int[] { i, j });
                    } else if (j + 1 < col && i + 1 < row && grid[i + 1][j + 1] == 1 && visited[i + 1][j + 1] == 0) {
                        count += 1;
                        i += 1;
                        j += 1;
                        visited[i][j] = count;
                        q.add(new int[] { i, j });
                    } else if (j - 1 >= 0 && i - 1 >= 0 && grid[i - 1][j - 1] == 1 && visited[i - 1][j - 1] == 0) {
                        count += 1;
                        i -= 1;
                        j -= 1;
                        visited[i][j] = count;
                        q.add(new int[] { i, j });
                    } else {
                        if (maxCount < count) {
                            maxCount = count;
                        }
                        break;
                    }

                }
            }

            return maxCount;
        }
    }
}
