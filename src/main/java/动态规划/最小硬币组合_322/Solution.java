package 动态规划.最小硬币组合_322;
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 937 👎 0


class Solution {
    //Time:O(n * m )    Space:O(n)
    public int coinChange(int[] coins, int amount) {
        int m = coins.length, n = amount;
        int[] dp = new int[n+1];
        for(int i = 1;i<=n;i++)dp[i] = Integer.MAX_VALUE;

        for(int i =1;i<=m;i++){
            for(int j =coins[i-1];j<=n ;j++){
                if(dp[j-coins[i-1]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j-coins[i-1]] + 1,dp[j]);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    //完全背包问题
    //定义dp(i,j)为前i件物品，总金额为j的最少硬币个数
    //dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1] + 1)
    //dp[i-1][j] 不使用第i个硬币的最少硬币数
    //dp[i][j-coins[i]] 使用前i个硬币兑换j-coins[i]的最少硬币数
    //Integer.MAX_VALUE代表此路不同，比如dp[0][j] j in(1,....amount) 用0个硬币去兑换一个数字

    //空间优化
    //dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1] + 1)   二维数组里，状态只依赖上一层同一列和当前层前置列得状态，所以一维状态可以省略，优化为:
    //dp[j] = Math.min(dp[j],dp[j-coins[i-1] + 1)
    //剪枝:当j<coins[i-1] dp[j] 一定找不到方案，为Integer.MAX_VALUE,即j直接从coins[i-1]开始
    //如果dp[j-coins[i-1]] 为无效方案，则dp[j] 还是dp[j],故进一步只判断if(dp[j-coins[i-1]] != Integer.MAX_VALUE)
    //详情见coinChange

    //Time:O(m * n)     Space:O(m * n)
    public int coinChange2(int[] coins, int amount) {
        int m = coins.length, n = amount;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i<=n;i++) dp[0][i] = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int curUseCoin = j >=coins[i-1] ? dp[i][j-coins[i-1]]: Integer.MAX_VALUE;
                if(curUseCoin != Integer.MAX_VALUE) curUseCoin += 1;
                dp[i][j] = Math.min(curUseCoin,dp[i-1][j]);
            }
        }
        return dp[m][n] == Integer.MAX_VALUE ? -1 : dp[m][n];
    }
}
