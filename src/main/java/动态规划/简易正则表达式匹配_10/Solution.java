//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//
// '.' 匹配任意单个字符
// '*' 匹配零个或多个前面的那一个元素
//
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
//
// 示例 1：
//
//
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
//
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3：
//
//
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4：
//
//
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5：
//
//
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false
//
//
//
// 提示：
//
//
// 0 <= s.length <= 20
// 0 <= p.length <= 30
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
// 保证每次出现字符 * 时，前面都匹配到有效的字符
//
// Related Topics 字符串 动态规划 回溯算法
// 👍 1659 👎 0
package 动态规划.简易正则表达式匹配_10;

public class Solution {

    //Time:O(m*n)   Space:O(m*n)
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int slen = s.length(), plen = p.length();

        boolean[][] dp = new boolean[plen + 1][slen + 1];
        dp[0][0] = true;
        for (int i = 1; i <= plen; i++) {
            if (p.charAt(i - 1) == '*') dp[i][0] = dp[i - 2][0];
        }
        for (int i = 1; i <= plen; i++) {
            for (int j = 0; j <= slen; j++) {
                if (j >= 1 && isEqual(s.charAt(j - 1), p.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 2][j];
                    if (j >= 1 && isEqual(s.charAt(j - 1), p.charAt(i - 2)))
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[plen][slen];
    }
    //dp(i,j)为字符串p前i个字符串匹配字符串s前j个字符串
    //1.最后一个字符相同p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '.' dp[i][j] = dp[i-1][j-1]
    //2.p的最后一个字符为*，因为*是对前一个串的复制，所以存在两种子情况。前一个串完全没有dp[i][j] = dp[i-2][j]，前一个串至少出现1次,dp[i][j] = dp[i][j-1];
    //3.其他情况字符串必不可能匹配

    private boolean isEqual(char a, char b) {
        return a == b || b == '.';
    }
}
