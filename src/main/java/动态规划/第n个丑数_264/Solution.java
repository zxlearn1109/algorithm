//编写一个程序，找出第 n 个丑数。
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
// Related Topics 堆 数学 动态规划
// 👍 417 👎 0
package 动态规划.第n个丑数_264;

public class Solution {

    //Time:O(n)     Space:O(n)
    public int nthUglyNumber(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = min(dp[p2] * 2, dp[p3] * 3, dp[p5] * 5);
            if (dp[p2] * 2 == dp[i]) p2++;
            if (dp[p3] * 3 == dp[i]) p3++;
            if (dp[p5] * 5 == dp[i]) p5++;
        }
        return dp[n - 1];
    }
    //第一个丑数为1，之后的每一个丑数一定是之前某一个位置乘2、乘3、乘5得来的。
    //维护三个指针，分别代表乘2、乘3、乘5，第i个丑数一定为这三个指针代表丑数乘以其本身的值中最小的数，最小的那个指针往后移动一位参与下次竞选

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
