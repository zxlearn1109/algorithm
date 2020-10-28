//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
//
//
//
// 提示：
//
//
// board 和 word 中只包含大写和小写英文字母。
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3
//
// Related Topics 数组 回溯算法
// 👍 663 👎 0
package 回溯.搜索单词_79;


public class Solution {
    // Time: O(m*n*3^k), Space: O(m*n)
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0
                || board[0] == null || board[0].length == 0
                || word == null || word.length() == 0)
            return false;

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(i, j, visited, board, word, 0)) return true;
            }
        }
        return false;
    }
    //思路
    //word的长度为n，需要决策n次。每次决策都有4种方案上下左右，如果数组角标越界或已经来过当前节点或者字符不匹配直接剪枝。
    //字符可以从任意起点开始

    private boolean backtracking(int i, int j, boolean[][] visited, char[][] board, String word, int start) {
        if (start == word.length()) return true;

        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || visited[i][j] || word.charAt(start) != board[i][j])
            return false;
        visited[i][j] = true;
        boolean vis = backtracking(i + 1, j, visited, board, word, start + 1)
                || backtracking(i - 1, j, visited, board, word, start + 1)
                || backtracking(i, j - 1, visited, board, word, start + 1)
                || backtracking(i, j + 1, visited, board, word, start + 1);
        visited[i][j] = false;
        return vis;
    }
}
