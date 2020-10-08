package tree.二叉树前序遍历_144;
//给定一个二叉树，返回它的 前序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 379 👎 0

import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    //Time:O(n)     Space:O(n)
    public List<Integer> preorderTraversal0(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                resultList.add(root.val);
                root = root.left;
            }
            root = stack.pop().right;
        }

        return resultList;
    }

    //Time:O(n)     Space:O(n)
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            resultList.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return resultList;
    }

    //Time:O(n)     Space:O(n)
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        preorderTraversalRecur(root, resultList);
        return resultList;
    }
    //思路
    //递归 深度优先
    //前序遍历直接保存结果

    private void preorderTraversalRecur(TreeNode root, List<Integer> resultList) {
        if (root == null) return;
        resultList.add(root.val);
        preorderTraversalRecur(root.left, resultList);
        preorderTraversalRecur(root.right, resultList);
    }
}
