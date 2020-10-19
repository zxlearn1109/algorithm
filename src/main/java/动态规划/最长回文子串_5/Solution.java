package 动态规划.最长回文子串_5;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
// 👍 2814 👎 0


class Solution {

    //Time:O(n^2)   Space:O(n^2)
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length(), start = 0, maxLen = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) dp[i][j] = true;
                if (i + 1 == j) dp[i][j] = s.charAt(i) == s.charAt(j);
                if (i != j && i + 1 != j) dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
    //思路:dp[i][j]代表从i到j的字符串是否为回文字符串
    //          1.i==j,dp[i][j]=true
    //          2.i+1==j,dp[i][j]=s.charAt(i)==s.charAt(j)
    //          3.i、j不是同一位置，且不相邻,dp[i][j] == s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
    //因为case3，i依赖i+1,j依赖j-1，所以i为[len-1,0],j为[i,len-1]   dp状态中没填到的各自都是非法状态，不需要管

    //Time:O(n^2)   Space:O(1)
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expands(s, i, i);
            int len2 = expands(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }
    //思路:从中间向两侧移动，找出最大的回文子串。中间情况有两种，奇数个和偶数个

    private int expands(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}

