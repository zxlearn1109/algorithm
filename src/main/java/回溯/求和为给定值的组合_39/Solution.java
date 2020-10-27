//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
//
//
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1：
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
//
//
// 示例 2：
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都是独一无二的。
// 1 <= target <= 500
//
// Related Topics 数组 回溯算法
// 👍 1018 👎 0
package 回溯.求和为给定值的组合_39;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // Time: O(n^(target/min)), Space: O(target/min)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> set = new HashSet<>();
        backtracking(0, target, candidates, new ArrayList<Integer>(), set);
        return new ArrayList<>(set);
    }

    private void backtracking(int start, int target, int[] candidates, List<Integer> path, Set<List<Integer>> set) {
        if (target == 0) {
            set.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) continue;
            path.add(candidates[i]);
            backtracking(i, target - candidates[i], candidates, path, set);
            path.remove(path.size() - 1);
        }
    }
}
