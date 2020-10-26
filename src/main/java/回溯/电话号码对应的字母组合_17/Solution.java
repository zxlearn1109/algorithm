package 回溯.电话号码对应的字母组合_17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法
// 👍 966 👎 0
public class Solution {

    // Time: O(4^n), Space: O(n)
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return Collections.EMPTY_LIST;

        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backtracking(0, digits, stringBuilder, result);
        return result;
    }
    //定义数字号码对应的字符数组mapping
    //start为决策数，总的决策数为digits.length()，当达到总的决策次数，需要保存结果
    //每次决策都是对mapping里的所有字符进行选择

    private void backtracking(int start, String digits, StringBuilder stringBuilder, List<String> result) {

        if (start == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        String options = mapping[digits.charAt(start) - '2'];
        for (int i = 0; i < options.length(); i++) {
            int len = stringBuilder.length();
            stringBuilder.append(options.charAt(i));
            backtracking(start + 1, digits, stringBuilder, result);
            stringBuilder.setLength(len);
        }

    }

    private final String[] mapping = new String[]{
            "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
    };

}
