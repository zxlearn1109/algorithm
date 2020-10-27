package 回溯.回文分割_131;
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
// 返回 s 所有可能的分割方案。
//
// 示例:
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//]
// Related Topics 回溯算法
// 👍 405 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    //Time:O(2^n)   Space:O(n^2)
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return Collections.EMPTY_LIST;
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        boolean[][] d = caclutedp(s);
        backtracking(0, s, d, path, result);
        return result;
    }
    //思路
    //dp(i,j)为字符串从i到j是否为回文字符串，公式为:
    // 1.if(i==j) d[i][j] = true
    // 2.if(i+1=j) d[i][j] = s.chatAt(i) == s.chatAt(j)
    // 3.d[i][j] = s.chatAt(i) == s.chatAt(j) && d[i+1][j-1]

    //定义start指针为开始索引，每次决策项为[start,s.length()-1],当start==s.length()递归终止

    private boolean[][] caclutedp(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        return dp;
    }

    private void backtracking(int start, String s, boolean[][] d, List<String> list, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (!d[start][i]) continue;
            list.add(s.substring(start, i + 1));
            backtracking(i + 1, s, d, list, result);
            list.remove(list.size() - 1);
        }

    }
}
