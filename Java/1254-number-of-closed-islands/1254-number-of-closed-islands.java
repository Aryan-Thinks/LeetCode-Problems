// https://leetcode.com/problems/number-of-closed-islands

class Solution {

    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        // Find all islands
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {

                    if (dfs(grid, i, j, m, n)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int i, int j, int m, int n) {

        // If outside the boundary, island is not closed
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        // Water is not part of the island
        if (grid[i][j] == 1) {
            return true;
        }

        // Mark land as visited
        grid[i][j] = 1;

        // Explore all four directions
        boolean up = dfs(grid, i - 1, j, m, n);
        boolean down = dfs(grid, i + 1, j, m, n);
        boolean left = dfs(grid, i, j - 1, m, n);
        boolean right = dfs(grid, i, j + 1, m, n);

        // Island is closed only if all directions stay inside
        return up && down && left && right;
    }
}

/*
    Approach:

    - Traverse every cell in the grid
    - If a cell contains 0, start DFS
    - Explore all four directions
    - If DFS goes outside the grid, the island is not closed
    - Mark visited land as 1 to avoid revisiting it
    - Count the island only if DFS returns true

    Time Complexity: O(m * n)
    Space Complexity: O(m * n)

    Important:
    - 0 represents land
    - 1 represents water
    - An island touching the boundary is not closed
    - Explore all four directions before combining results
*/
