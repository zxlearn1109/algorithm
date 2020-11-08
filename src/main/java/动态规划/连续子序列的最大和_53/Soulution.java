//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划
// 👍 2606 👎 0
package 动态规划.连续子序列的最大和_53;

public class Soulution {
    //Time:O(n)     Space:O(1)
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int cur =0,max =Integer.MIN_VALUE;

        for(int i =0;i<nums.length;i++){
            cur = cur>=0?cur+nums[i] : nums[i];
            max = Math.max(cur,max);
        }
        return max;
    }
    //求连续子序列的最大和，当一段序列的和值为负数，它一定不属于最大子序列的一部分
    //定义max用来存储算出的子序列最大和,cur代表当前的子序列，如果大于0，则加上i所在的数字，和max比对求较大值。若小于0，则将cur置为i当前的数字
}
