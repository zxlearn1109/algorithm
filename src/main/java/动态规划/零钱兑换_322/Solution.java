package 动态规划.零钱兑换_322;

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
// 👍 894 👎 0
public class Solution {

    //Time:O(N*V)   Space:O(V)
    //N为coins的length,V为总金额
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int j = 1; j <= amount; j++) dp[j] = amount + 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    //思路:一般问最优值是多少，而没有问最优解，都可以考虑动态规划思路
    //此问题和和完全背包问题较像，完全背包递归公式dp[i][j] = Math,max(dp[i-1][j] , dp[i][j-w[i]] + v[i])
    //将完全背包的体积限制改为此题的金额限制，状态定义由最大价值变为硬币的最少个数，公式为:dp[i][j] = Math.min(dp[i-1][j],dp[i][j-w[i]] + 1)
    //空间优化，每个dp[i][j]都依赖于上一层的j和当前层的前置项j-w[i],所以应该正向遍历
    //完全背包问题:https://www.acwing.com/video/945/
}
