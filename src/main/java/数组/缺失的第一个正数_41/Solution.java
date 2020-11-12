//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
//
//
//
// 示例 1:
//
// 输入: [1,2,0]
//输出: 3
//
//
// 示例 2:
//
// 输入: [3,4,-1,1]
//输出: 2
//
//
// 示例 3:
//
// 输入: [7,8,9,11,12]
//输出: 1
//
//
//
//
// 提示：
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
// Related Topics 数组
// 👍 847 👎 0
package 数组.缺失的第一个正数_41;

public class Solution {

    //Time:O(n)     Space:O(1)
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < len; i++) {
            if (i != nums[i] - 1) return i + 1;
        }
        return len + 1;
    }
    //思路:
    //遍历数组，只要正数且在[0,len-1]内，都将其放在减1的下标上.负数和大于len的数不处理
    //第二次遍历数组，如果i+1！=nums[i]，这就是缺失的正整数

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
