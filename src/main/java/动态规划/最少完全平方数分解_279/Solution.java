package 动态规划.最少完全平方数分解_279;
//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 683 👎 0


class Solution {
    //Time:O(n ^ 3 / 2)     Space:O(n)
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j<=i;j++){
                min = Math.min(min,dp[i-(j * j)]+1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
    //dp(i) 是数字i的最少完全平方数分解
    //dp[i] = min (dp[i],dp[i-k])  k:小于i的平方数  k = j * j  j从1开始
}
