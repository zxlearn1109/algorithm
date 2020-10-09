package tree.二叉树中和为给定值的路径_113;
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
// 👍 360 👎 0
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
// 👍 360 👎 0

import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

    // Time: O(n), Space: O(n)
    public List<List<Integer>> pathSumIter(TreeNode root, int sum) {
        if (root == null) return Collections.EMPTY_LIST;

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> visited = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            //root不为null，就往stack里push节点，标记当前节点已访问，保存当前路径的值，目标值进行扣减，root指向左子树
            while (root != null) {
                stack.push(root);
                visited.push(root);
                list.add(root.val);
                sum -= root.val;
                root = root.left;
            }

            //root == null peek出上一个root
            TreeNode node = stack.peek();
            //从栈里peek出得node，其左子树我们一定访问过，故而直接看右子树
            //此时有3种情况，
                // 1.node.right == null         有两种情况，left不为 null和left为null。left为null需判断sum值是否为0，为0的话添加到结果集中
                // 2.visited.contains(node.right)       已经访问过，避免再次访问
                // 3.node.right == null && !visited.contains(node.right)    有未访问过的右子树，直接重置root指针，重新开始流程
            if (node.right == null || visited.contains(node.right)) {
                if (node.left == null && node.right == null && sum == 0) {
                    resultList.add(new ArrayList<>(list));
                }
                stack.pop();
                list.remove(list.size() - 1);
                sum += node.val;
            } else root = node.right;

        }
        return resultList;
    }
    //思路
    //迭代    深度优先

    // Time: O(n), Space: O(n)
    public List<List<Integer>> pathSumIter2(TreeNode root, int sum) {
        if (root == null) return Collections.EMPTY_LIST;

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //和pathSumIter()的区别：用prev指针保存上次栈弹出的节点，如果当前节点的右指针==prev则代表访问过
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                list.add(root.val);
                sum -= root.val;
                root = root.left;
            }

            TreeNode node = stack.peek();
            if (node.right == null || node.right.equals(prev)) {
                if (node.left == null && node.right == null && sum == 0) {
                    resultList.add(new ArrayList<>(list));
                }
                prev = node;
                stack.pop();
                list.remove(list.size() - 1);
                sum += node.val;
            } else root = node.right;

        }
        return resultList;
    }



    // Time: O(n), Space: O(n)
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return Collections.EMPTY_LIST;
        List<List<Integer>> resultList = new ArrayList<>();
        pathSum(root, sum, resultList, new ArrayList<Integer>());
        return resultList;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> resultList, ArrayList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.right == null && root.left == null && root.val == sum) resultList.add(new ArrayList<>(list));
        pathSum(root.left, sum - root.val, resultList, list);
        pathSum(root.right, sum - root.val, resultList, list);
        list.remove(list.size() - 1);
    }


}
