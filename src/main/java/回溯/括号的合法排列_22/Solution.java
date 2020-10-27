package 回溯.括号的合法排列_22;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法
// 👍 1385 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    // Time: O(4^n / sqrt(n)), Space: O(n)
    public List<String> generateParenthesis(int n) {
        if (n < 1) return Collections.EMPTY_LIST;
        List<String> result = new ArrayList<>();
        backtracking(0, 0, n, new StringBuilder(), result);
        return result;
    }
    //思路
    //每次决策只可能是左括号"("或右括号")"
    //如果左括号已经用完，又决策到左括号，进行剪枝
    //如果左右括号数量相同，决策到右括号，进行剪枝

    private void backtracking(int left, int right, int n, StringBuilder stringBuilder, List<String> result) {
        if (left == right && left == n) {
            result.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (left == n && i == 0) continue;
            if (left == right && i == 1) continue;
            int len = stringBuilder.length();
            stringBuilder.append(i == 0 ? "(" : ")");
            backtracking(i == 0 ? left + 1 : left, i == 0 ? right : right + 1, n, stringBuilder, result);
            stringBuilder.setLength(len);
        }

    }

}
