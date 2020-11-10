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
