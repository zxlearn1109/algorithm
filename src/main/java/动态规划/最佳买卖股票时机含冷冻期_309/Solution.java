package 动态规划.最佳买卖股票时机含冷冻期_309;//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 603 👎 0


class Solution {
    //Time:O(n)     Space:O(1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int profit0 = 0, profit1 = -prices[0], prevprofit0 = 0;
        for (int i = 1; i < n; i++) {
            int nextprofit0 = Math.max(profit0, profit1 + prices[i]);
            int nextprofit1 = Math.max(profit1, prevprofit0 - prices[i]);
            prevprofit0 = profit0;
            profit0 = nextprofit0;
            profit1 = nextprofit1;
        }
        return profit0;
    }
    //思路
    //T[i][k][0] = max(T[i-1][k][0],T[i-1][k][1]+prices[i])  今天持有0股，可以分为今天休息和昨天有1股今天卖出
    //T[i][k][1] = max(T[i-1][k][1],T[i-2][k-1][0]-prices[i]) 今天持有1股，可以分为今天休息和前天买入
    //由于k无限制，k为无穷大，T[i-2][k-1][0] = T[i-2][k][0]
    //k优化后
    //T[i][0] = max(T[i-1][0],T[i-1][1]+prices[i])
    //T[i][1] = max(T[i-1][1],T[i-2][0]-prices[i])
    //i只依赖i-1和i-2可以继续优化空间
    //股票问题通解：https://leetcode-cn.com/circle/article/qiAgHn/
}
