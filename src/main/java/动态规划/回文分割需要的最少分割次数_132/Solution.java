package 动态规划.回文分割需要的最少分割次数_132;
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
// 返回符合要求的最少分割次数。
//
// 示例:
//
// 输入: "aab"
//输出: 1
//解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
//
// Related Topics 动态规划
// 👍 215 👎 0
class Solution {
    //Time:O(n^2)   Space:O(n^2)
    public int minCut(String s) {
        if (s == null || s.length() == 0) return -1;
        int len = s.length();
        boolean[][] palindrome = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    palindrome[i][j] = true;
                } else if (i + 1 == j) {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else
                    palindrome[i][j] = s.charAt(i) == s.charAt(j) && j >= 1 && palindrome[i + 1][j - 1];
            }
        }

        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (palindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (palindrome[j + 1][i]) min = Math.min(min, dp[j]);
            }
            dp[i] = min + 1;
        }
        return dp[len - 1];
    }
    //思路:求s的子串都是回文的最少分割次数
    //定义dp[i] 为[0,i]字串都是回文的最少分割次数，比较容易想到的是s[0,i]是回文字符串则dp[i] = 0;否则dp[i]我们就需要划成子问题去求解
    //假设[0,i]之间有分割点j，使得s[j+1,i]是回文字符串，则dp[i] = dp[j]+1;  j循环[0,i]，dp[i]取其中最小值，最终dp[len-1]即为最少分隔次数

}