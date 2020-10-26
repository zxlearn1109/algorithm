//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法
// 👍 853 👎 0
package 回溯.数组的子集_78;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    // Time: O(2^n), Space: O(n)
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return Collections.EMPTY_LIST;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, nums.length, 0, path, result);
        return result;
    }
    //决策次数为nums.length(),当全部决策或着当前决策选中的可选项为num.length()，直接返回结果

    private void backtracking(int[] nums, int len, int start, List<Integer> path, List<List<Integer>> result) {
        if (len == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= nums.length; i++) {
            if (i == nums.length) {
                result.add(new ArrayList<>(path));
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, len - 1, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    // Time: O(2^n), Space: O(n)
    public List<List<Integer>> subsets2(int[] nums) {
        if (nums == null) return Collections.EMPTY_LIST;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(nums, 0, path, result);
        return result;
    }
    //针对回溯的每一步都保存其结果集

    private void backtracking(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
