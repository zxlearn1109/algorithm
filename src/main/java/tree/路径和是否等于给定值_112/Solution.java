package tree.路径和是否等于给定值_112;
//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
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
//         /  \      \
//        7    2      1
//
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
// Related Topics 树 深度优先搜索
// 👍 440 👎 0


import tree.structure.TreeNode;

import java.util.Stack;

public class Solution {
    //Time:O(n)     Space:O(n)
    public boolean hasPathSumRecur(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSumRecur(root.left, sum - root.val) || hasPathSumRecur(root.right, sum - root.val);
    }
    //思路
    //递归    深度优先
    //当前节点是叶子节点且数值等于sum返回true

    //Time:O(n)     Space:O(n)
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        stack.push(root);
        numStack.push(sum);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Integer num = numStack.pop();
            if (node.left == null && node.right == null && node.val == num) return true;
            if (node.left != null) {
                stack.push(node.left);
                numStack.push(num - node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
                numStack.push(num - node.val);
            }
        }
        return false;
    }
    //思路
    //迭代    宽度优先
    //采用双栈，一个保存节点，一个保存扣减后的num

}
