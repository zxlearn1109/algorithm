//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//
//
// 示例 1：
//
//
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
//
// 示例 2：
//
//
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3
//。
//
//
//
// 提示：
//
//
// 0 <= k <= 109
// 0 <= prices.length <= 1000
// 0 <= prices[i] <= 1000
//
// Related Topics 动态规划
// 👍 324 👎 0
package 动态规划.买卖股票的最佳时机IV;

public class Solution {

    //Time:O(n * k)     Space:O(k)
    public int maxProfit(int k, int[] prices) {
        if (k < 1 || prices == null || prices.length < 2) return 0;

        if (k >= prices.length / 2) return maxProfit(prices);
        int[][] dp = new int[k + 1][2];
        for (int j = 0; j <= k; j++) {
            dp[j][0] = 0;
            dp[j][1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = k; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }

        return dp[k][0];
    }
    //状态方程
    // T[i][k][0] = max(T[i-1][k][0],T[i-1][k][1]+prices[i])
    // T[i][k][1] = max(T[i-1][k][1],T[i-1][k-1][0] - prices[i])
    //i的状态只依赖i-1可以优化，且当持有货物时，k依赖k-1，应该倒序排列
    //不明白的时候，翻看https://leetcode-cn.com/circle/article/qiAgHn/

    private int maxProfit(int[] prices) {
        int max = 0, max1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int oldmax = max;
            max = Math.max(max, max1 + prices[i]);
            max1 = Math.max(max1, oldmax - prices[i]);
        }
        return max;
    }

}
