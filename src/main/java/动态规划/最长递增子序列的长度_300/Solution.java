//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例:
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
// 说明:
//
//
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
// 你算法的时间复杂度应该为 O(n2) 。
//
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
// Related Topics 二分查找 动态规划
// 👍 1139 👎 0
package 动态规划.最长递增子序列的长度_300;

public class Solution {

    //Time:O(n*logn)    Space:O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, len = 0;
        int[] dp = new int[n];
        for (int num : nums) {
            int idx = findInsertposition(dp, len, num);
            dp[idx] = num;
            if (idx == len) len++;
        }
        return len;
    }
    //思路:dp[i] 长度为i的所有上升子序列的最小结尾
    //使用二分法查询num在dp中应该插入的位置，如果位置idx==len，则dp长度+1

    private int findInsertposition(int[] dp, int len, int num) {
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num == dp[mid]) return mid;
            if (num > dp[mid]) low = mid + 1;
            if (num < dp[mid]) high = mid - 1;
        }
        return low;
    }

    //Time:O(n^2)   Space:O(n)
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, max = 1;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    //思路
    //定义dp[i]为以nums[i]结尾的最长上升子序列的组合长度,所以最长上升子序列的长度应该为所有情况的最大值
    //dp[i] = max foreach j in (0,i-1) nums[i]>nums[j]? dp[j]+1:1

}
