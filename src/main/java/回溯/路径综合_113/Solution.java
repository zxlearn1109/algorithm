//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
// Related Topics 树 深度优先搜索
// 👍 370 👎 0
package 回溯.路径综合_113;

import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return Collections.EMPTY_LIST;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(root, sum, path, result);
        return result;
    }

    private void backtracking(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) return;

        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(path));
        }
        backtracking(root.left, sum - root.val, path, result);
        backtracking(root.right, sum - root.val, path, result);
        path.remove(path.size() - 1);
    }
}
