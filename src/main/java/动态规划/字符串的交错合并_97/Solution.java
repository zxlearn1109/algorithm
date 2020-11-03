//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
//
//
// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// |n - m| <= 1
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
//
//
// 提示：a + b 意味着字符串 a 和 b 连接。
//
//
//
// 示例 1：
//
//
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
//
//
// 示例 2：
//
//
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
//
//
// 示例 3：
//
//
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
//
//
//
//
// 提示：
//
//
// 0 <= s1.length, s2.length <= 100
// 0 <= s3.length <= 200
// s1、s2、和 s3 都由小写英文字母组成
//
// Related Topics 字符串 动态规划
// 👍 365 👎 0
package 动态规划.字符串的交错合并_97;

public class Solution {

    //Time:O(n1*n2)     Space:O(n1*n2)
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) return false;

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n1 && s1.charAt(i - 1) == s3.charAt(i - 1); i++) dp[i][0] = true;
        for (int i = 1; i <= n2 && s2.charAt(i - 1) == s3.charAt(i - 1); i++) dp[0][i] = true;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[n1][n2];
    }
    //定义状态d(i,j)为s1前i个字符、s2前j个字符是否可以拼接s3前i+j个字符
    //1:s3.charAt(i+j-1) == s1.chatAt(i-1) dp[i][j] = dp[i-1][j]
    //2:s3.chatAt(i+j-1) == s2.charAt(j-1) dp[i][j] = dp[i][j-1]
}
