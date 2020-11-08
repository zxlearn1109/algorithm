//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划
// 👍 826 👎 0
package 动态规划.连续子序列的最大乘积_152;

public class Solution {

    //Time:O(n)     Space:O(1)
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], curmax = nums[0], curmin = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            int a = nums[i], b = nums[i] * curmax, c = nums[i] * curmin;
            curmax = max(a, b, c);
            curmin = min(a, b, c);
            max = Math.max(max, curmax);
        }
        return max;
    }
    //max:全局最大乘积，curmax为以第i个数字为结尾的连续子数组的最大乘积，curmin为以第i个数字为结尾的连续子数组的最小乘积
    //为什么要保存curmin,因为乘法最小乘积乘负数就变成了最大乘积

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

}
