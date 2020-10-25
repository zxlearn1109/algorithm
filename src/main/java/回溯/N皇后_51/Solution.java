package 回溯.N皇后_51;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
// 示例：
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
//
//
//
// 提示：
//
//
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
//
// Related Topics 回溯算法
// 👍 649 👎 0
public class Solution {

    //Time:O(n!)    Space:O(n ^ 2)
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return Collections.EMPTY_LIST;

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) board[i][j] = '.';
        }

        List<List<String>> result = new ArrayList<>();
        boolean[][] visited = new boolean[3][2 * n];
        backtracking(0, n, board, result, visited);
        return result;
    }
    //思路:经典的回溯算法
    //1.初始化长宽为n的棋盘，复制为'.'
    //2.写递归函数，我们需要做n次选择，每次选择枚举项为[0,n-1]。由题意可得，我们应该做合法性校验，回溯里叫剪枝。】
    //  假设当前节点是row行、col列，所有的col列不能有皇后，所有的row-i行，col-i列不能有皇后，所有的row-i行,col+i列不能有皇后。i取值[1,row]
    //  上述校验合法性的方法是O(n)的，可以继续优化成O(1)的。如solveNQueens函数中的visited数组，
    // 0行代表所有行当前列是否有皇后，1行代表从左往右的对角线是否有皇后，2行代表从右往左的对角线是否有皇后.
    // 对于任意一个row,col，只要visited上没出现过皇后，当前节点都是合理的。
    // level-i+n 从左到右的对角线level-i是固定的值，但有可能为负数需要+n，可以将这条对角线是否出现过皇后的信息统一由leve-i+n来标识
    // level + i 从右到做的对角线level+i是固定的值，可以将这条对角线是否出现过皇后的信息统一由level + i来标识

    private void backtracking(int level, int n, char[][] board, List<List<String>> result, boolean[][] visited) {
        if (level == n) {
            result.add(buildList(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[0][i] && !visited[1][level - i + n] && !visited[2][level + i]) {
                visited[0][i] = true;
                visited[1][level - i + n] = true;
                visited[2][level + i] = true;
                board[level][i] = 'Q';
                backtracking(level + 1, n, board, result, visited);
                board[level][i] = '.';
                visited[0][i] = false;
                visited[1][level - i + n] = false;
                visited[2][level + i] = false;
            }
        }

    }


    private List<String> buildList(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }

}
