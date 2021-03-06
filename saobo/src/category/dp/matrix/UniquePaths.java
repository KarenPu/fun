package category.dp.matrix;

public class UniquePaths {

    public static void main(String[] args) {
        int[][] grid = { { 0, 0 }, { 0, 1 } };

        System.out.println(new UniquePaths().uniquePathsWithObstacles(grid));

    }

    /**
     * [Leetcode 62] https://leetcode.com/problems/unique-paths/
     *
     * <pre>
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below). The robot can
     * only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the
     * grid (marked 'Finish' in the diagram below). How many possible unique paths are there?
     * </pre>
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] path = new int[m][n];

        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            path[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }

        return path[m - 1][n - 1];
    }

    /**
     * [Leetcode 63] https://leetcode.com/problems/unique-paths-ii/
     * 
     * <pre>
     * Follow up for "Unique Paths":
     * 
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * 
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * 
     * For example,
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * 
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * The total number of unique paths is 2.
     * 
     * Note: m and n will be at most 100.
     *
     * </pre>
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0
                || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] count = new int[rows][cols];
        count[0][0] = 1;

        for (int i = 0; i < cols - 1; i++) {
            if (obstacleGrid[0][i] == 0 && obstacleGrid[0][i + 1] == 0) {
                count[0][i + 1] = count[0][i];
            } else {
                count[0][i + 1] = 0;
            }
        }

        for (int i = 0; i < rows - 1; i++) {
            if (obstacleGrid[i][0] == 0 && obstacleGrid[i + 1][0] == 0) {
                count[i + 1][0] = count[i][0];
            } else {
                count[i + 1][0] = 0;
            }
        }

        for (int i = 1; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                if (obstacleGrid[j][i] == 1) {
                    count[j][i] = 0;
                } else {
                    count[j][i] = count[j - 1][i] + count[j][i - 1];
                }
            }
        }

        return count[rows - 1][cols - 1];
    }

}
