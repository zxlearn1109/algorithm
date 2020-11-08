//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
//
//
// 示例：
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
//
//
//
//
// 提示：
//
//
// 1 <= len(A), len(B) <= 1000
// 0 <= A[i], B[i] < 100
//
// Related Topics 数组 哈希表 二分查找 动态规划
// 👍 342 👎 0
package 动态规划.最长重复子数组_718;

public class Solution {
    //Time:O(m*n)     Space:O(n)
    public int findLength(int[] A, int[] B) {
        int n1 = A.length, n2 = B.length;
        int[] dp = new int[n2 + 1];
        int max = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = n2; j >= 1; j--) {
                dp[j] = A[i - 1] != B[j - 1] ? 0 : dp[j - 1] + 1;
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
    //重复子数组：dp(i)(j)代表A数组以第i个数字结尾和B数字以第j个数字结尾的最长重复子数组
    //dp[j] = A[i - 1] != B[j - 1] ? 0 : dp[j - 1] + 1;
}
