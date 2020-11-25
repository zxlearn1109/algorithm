//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//
// Related Topics 字符串 动态规划
// 👍 1082 👎 0
package 动态规划.有效括号的最大长度_32;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    //Time:O(n)     Space:O(n)
    public int longestValidParenthesesStack(String s) {
        if (s == null || s.length() < 2) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || stack.peek() < 0 || s.charAt(stack.peek()) != '(') {
                stack.push(i);
            } else {
                stack.pop();
                max = Math.max(i - stack.peek(), max);
            }
        }
        return max;
    }
    //有效括号长度一般用栈结构，java中栈结构一般选择arrayDeque(jdk推荐)
    //1.遇到左括号，将下标放入栈中
    //2.遇到右括号，判断栈顶
    //                  2.1若为左括号，可以组成有效长度。栈依次做pop,peek，当前索引i-stack.peek()为以i为结尾最长的有效长度
    //                  2.2若为右括号，将右括号推入栈里。下一个有效长度串的分割点...
    //3.考虑到()这种情况，当i为1时，先pop在peek时为空，事先推入-1..


    //Time:O(n)     Space:O(n)
    public int longestValidParenthesesDP(String s) {
        if (s == null || s.length() < 2) return 0;
        int len = s.length(), max = 0, left = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (left > 0) {
                dp[i] = 2 + dp[i - 1];
                if (i - dp[i] >= 0) dp[i] += dp[i - dp[i]];
                left--;
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
    //left代表当前左括号的个数，遇上右括号会进行减1,dp(i)为以i为结尾的最长有效括号个数
    // (()) 大括号包小括号,i为下标,dp[3] = 2 + dp[3-1]  --> dp[i] = 2 + dp[i-1]
    // ()() 两个括号挨着,i为下标,dp[3] = 2 + dp[3-1],dp[3] = dp[3] + dp[i-dp[i]]
    //左括号只对left++，碰到右括号若左括号为0不处理，反之则考虑上述两种情况

}
