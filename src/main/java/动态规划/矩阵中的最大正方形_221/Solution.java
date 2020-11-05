//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例:
//
// 输入:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4
// Related Topics 动态规划
// 👍 605 👎 0
package 动态规划.矩阵中的最大正方形_221;

public class Solution {

    //Time:O(m*n)   Space:O(n)
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;

        int[] dp = new int[n];

        int max = 0, pre = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = dp[j];
                if (i == 0 || j == 0 || matrix[i][j] == '0') {
                    dp[j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    dp[j] = min(dp[j], dp[j - 1], pre) + 1;
                }
                max = Math.max(dp[j], max);
                pre = tmp;
            }
        }
        return max * max;
    }

    //Time:O(m*n)   Space:O(m*n)
    public int maximalSquare1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;

        Integer max = 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || matrix[i][j] == '0') {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
