package tree.判断二叉树是否平衡_110;
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//
// 示例 1:
//
// 给定二叉树 [3,9,20,null,null,15,7]
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回 true 。
//
//示例 2:
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// 返回 false 。
//
//
// Related Topics 树 深度优先搜索
// 👍 490 👎 0

import tree.structure.TreeNode;

public class Solution {

    //Time:O(n)     Space:O(n)
    public boolean isBalanced(TreeNode root) {
        return getHeightAndCheck(root) != -1;
    }

    private int getHeightAndCheck(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeightAndCheck(root.left);
        if (leftHeight == -1) return leftHeight;
        int rightHeight = getHeightAndCheck(root.right);
        if (rightHeight == -1) return rightHeight;

        return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }

    //思路
    //递归 深度优先
    //树平衡的特性，就是其上的每个节点的左右子树高度相差不大于1。当前节点的高度为左右子树最大值+1
    //左右子树高度值相差大于1，直接返回-1，标识不平衡，省略以后计算

    //Time:O(nlog(n))     Space:O(n)
    public boolean isBalancedRecur(TreeNode root) {
        if (root == null) return true;
        return isBalancedRecur(root.left) && isBalancedRecur(root.right)
                && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    //思路
    //递归 深度优先
    //比较左右孩子子树是否平衡，平衡的的话左右子树高度相差小于1则树平衡
}
