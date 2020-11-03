//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//
//
// 示例 1：
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
//
//
// 示例 2：
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
//
//
// 提示：
//
//
// 输入的字符串长度不会超过 1000 。
//
// Related Topics 字符串 动态规划
// 👍 428 👎 0
package 动态规划.回文子串个数_647;

public class Solution {

    //Time:O(n^2)   Space:O(n)
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            cnt += expand(s, i, i);
            if (i + 1 < len) cnt += expand(s, i, i + 1);
        }
        return cnt;
    }
    //思路:遍历字符串的每个位置，将当前位置的字符作为中心向两边遍历如果相等，回文串+1。不应忽律偶数长度，中心为双字符的情况
    //tips:同样的时间复杂度，比动态规划快了许多...

    private int expand(String s, int left, int right) {
        if (s.charAt(left) != s.charAt(right)) return 0;
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            cnt++;
        }
        return cnt;
    }

    //Time:O(n^2)   Space:O(n^2)
    public int countSubstringsdp(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        boolean[][] palindrome = new boolean[len][len];
        int cnt = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (j == i) {
                    palindrome[i][j] = true;
                } else if (i + 1 == j) {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else
                    palindrome[i][j] = s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1];
                if (palindrome[i][j]) cnt++;
            }
        }
        return cnt;
    }
    //思路：状态定义dp[i][j]为字符串s，下标i到j的子串是否是回文字符串
    //dp[i][j]
    //          1.i==j   dp[i][j] = true                        一个字符肯定为true
    //          2.i+1==j dp[i][j] = s.chatAt(i) == s.chatAt(j)
    //          3.!1&&!2 dp[i][j] = s.chatAt(i) == s.chatAt(j) && dp[i+1][j-1] ij不是同一位置且不相邻，如果ij上字符相等，则将问题转移到子问题i+1,j-1上。所以遍历顺序，i从大到小，j从小到大


}
