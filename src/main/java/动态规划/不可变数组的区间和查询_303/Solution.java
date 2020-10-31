package 动态规划.不可变数组的区间和查询_303;

public class Solution {

    private int[] dp;

    public Solution(int[] nums) {
        dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = i >= 1 ? dp[i - 1] + nums[i] : nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return dp[j];
        return dp[j] - dp[i - 1];
    }
    //d(n):索引0到n的数据和，d(n) = d(n-1)+nums[n];   i~j的和为d(j) - d(i-1)
}
