package tree.判断二叉树是否相同_100;

import tree.structure.TreeNode;

import java.util.Stack;

//给定两个二叉树，编写一个函数来检验它们是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
// 示例 1:
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true
//
// 示例 2:
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
//
//
// 示例 3:
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
//
// Related Topics 树 深度优先搜索
// 👍 482 👎 0
public class Solution {

    //Time:O(n)     Space:O(n) average:O(logn)
    public boolean isSameTreeRecur(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        return p != null && q != null && q.val == p.val && isSameTreeRecur(p.left, q.left) && isSameTreeRecur(p.right, q.right);
    }

    //Time:O(n)     Space:O(n)  average:O(logn)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            stack.push(left.left);
            stack.push(right.left);
            stack.push(left.right);
            stack.push(right.right);
        }
        return true;
    }

    //思路:比较两个树的节点，如果都为null或者都不为null且两个节点值相同则进入下一步，否则直接返回false
    //下一步依次比较两个节点的左节点和右节点。可以借助递归和stack来报纸节点顺序
}
