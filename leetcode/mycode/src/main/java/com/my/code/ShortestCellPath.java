package com.my.code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShortestCellPath {
    public void callSolution(int[][] grid, int sr, int sc, int tr, int tc) {
        Solution sln = new Solution();
        int path = sln.shortestCellPath(grid, sr, sc, tr, tc);
        System.out.println(path);
    }
}

class Solution {

    int pathLength = Integer.MAX_VALUE;
    boolean[][] visited;
    int row;
    int col;
    boolean reachedDestination = false;
    int minCount = Integer.MAX_VALUE;

    int dfs(int[][] grid, int r, int c, int tr, int tc) {

        if (r >= row || c >= col || r < 0 || c < 0 || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }
        if (r == tr && c == tc) {
            reachedDestination = true;
            return 0;
        }

        visited[r][c] = true;
        int count = 1;

        int dcount = dfs(grid, r, c + 1, tr, tc);
        if (reachedDestination) {
            count += dcount;
        }

        dcount = dfs(grid, r, c - 1, tr, tc);
        if (reachedDestination) {
            count += dcount;
        }

        dcount = dfs(grid, r + 1, c, tr, tc);
        if (reachedDestination) {
            count += dcount;
        }

        dcount = dfs(grid, r - 1, c, tr, tc);
        if (reachedDestination) {
            count += dcount;
        }

        return count;
    }

    int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // your code goes here
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];

        int[][] visited2 = new int[row][col];

        // dfs(grid, sr, sc, tr, tc);

        Queue<Integer[]> q = new LinkedList<>();

        q.add(new Integer[] { sr, sc });
        visited2[sr][sc] = 1;

        while (q.size() != 0) {
            Integer[] rc = q.poll();
            int r = rc[0];
            int c = rc[1];
            int count = visited2[r][c];
            if (r == tr && c == tc) {
                return count;
            }
            // while (true) {
            if (r < row && c + 1 < col && r >= 0 && c >= 0 && grid[r][c + 1] != 0 && visited2[r][c + 1] == 0) {
                q.add(new Integer[] { r, c + 1 });
                visited2[r][c + 1] = count + 1;
            }
            if (r < row && c < col && r >= 0 && c - 1 >= 0 && grid[r][c - 1] != 0 && visited2[r][c - 1] == 0) {
                q.add(new Integer[] { r, c - 1 });
                visited2[r][c - 1] = count + 1;
            }
            if (r + 1 < row && c < col && r >= 0 && c >= 0 && grid[r + 1][c] != 0 && visited2[r + 1][c] == 0) {
                q.add(new Integer[] { r + 1, c });
                visited2[r + 1][c] = count + 1;
            }
            if (r < row && c < col && r - 1 >= 0 && c >= 0 && grid[r - 1][c] != 0 && visited2[r - 1][c] == 0) {
                q.add(new Integer[] { r - 1, c });
                visited2[r - 1][c] = count + 1;
            }

            // }
        }

        return -1;
    }
}
