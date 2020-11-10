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
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0, cur = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - cur, max);
            cur = Math.min(cur,prices[i]);
        }
        return max;
    }

    //经典动态规划思想，维护一个最小指针买入价cur，最大利润max。max = Math.max(max,prices[i]-cur,max)
    // 当前的最大利润等于 max(之前的最大利润，当天卖出的最大利润)

}
