//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//
// 注意：你不能在买入股票前卖出股票。
//
//
//
// 示例 1:
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//
//
// 示例 2:
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
// Related Topics 数组 动态规划
// 👍 1288 👎 0
package 动态规划.买卖股票的最大利润_121;

public class Solution {

    //Time:O(n)     Space:O(1)
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int max0 = 0, max1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            max0 = Math.max(max0, max1 + prices[i]);
            max1 = Math.max(max1, -prices[i]);
        }
        return max0;
    }
    //股票相关 通用思路
    //i为当前天数，取值范围[0,prices.length-1]
    //k为交易次数,只有在买入的时候交易次数+1   本题k限制为1
    //数组第三维0代表不持有股票，1代表持有股票。当为0时，昨天只能卖出股票或者休息。当为1时昨天只能买入股票(k+1)或者休息
    //T[i][k][0] = max(T[i-1][k][0],T[i-1][k][1] + prices[i])
    //T[i][k][1] = max(T[i-1][k][1],T[i-1][k-1][0] - prices[i])
    //k只能为1，于是状态方程变为T[i][0] = max(T[i-1][0],T[i-1][1] + prices[i])
    //                        T[i][1] = max(T[i-1][1],T[i-1][0] - prices[i])   T[i-1][0] 是T[i-1][k-1][0]转化而来，k为1，所以其永远为0
    //第i天的状态只依赖i-1的状态，可以继续优化为两个指针
    //https://leetcode-cn.com/circle/article/qiAgHn/  股票问题系列通解

    //Time:O(n)     Space:O(1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
    //思路
    //min为当天及之前的最小价格，每天都取记录最小的买入价格，每天都去尝试卖出保留最高的利润

}
