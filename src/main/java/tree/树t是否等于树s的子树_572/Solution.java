package tree.树t是否等于树s的子树_572;
//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。
//
// 示例 1:
//给定的树 s:
//
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//
//
// 给定的树 t：
//
//
//   4
//  / \
// 1   2
//
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
//
// 示例 2:
//给定的树 s：
//
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
//
//
// 给定的树 t：
//
//
//   4
//  / \
// 1   2
//
//
// 返回 false。
// Related Topics 树
// 👍 369 👎 0

import tree.structure.TreeNode;

public class Solution {

    //Time:O(m * n)     Space:O(h)    m为s的数据量，n为t的数据量  h为s的高度
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    //思路
    //递归    深度优先
    //如果t树是s的子树，有三种可能
    //                          1.t==s
    //                          2.t-->s.left  t在左子树上
    //                          3.t==s.right  t在右子树上

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
