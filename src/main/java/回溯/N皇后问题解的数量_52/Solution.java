package 回溯.N皇后问题解的数量_52;

public class Solution {
    //Time:O(n!)    Space:O(n)  思路见51题..
    public int totalNQueens(int n) {

        boolean[][] visited = new boolean[3][2 * n];
        int[] sum = new int[1];
        backtracking(0, n, visited, sum);
        return sum[0];
    }

    private void backtracking(int level, int n, boolean[][] visited, int[] sum) {
        if (level == n) {
            sum[0]++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[0][i] && !visited[1][level - i + n] && !visited[2][level + i]) {
                visited[0][i] = visited[1][level - i + n] = visited[2][level + i] = true;
                backtracking(level + 1, n, visited, sum);
                visited[0][i] = visited[1][level - i + n] = visited[2][level + i] = false;
            }
        }

    }
}
