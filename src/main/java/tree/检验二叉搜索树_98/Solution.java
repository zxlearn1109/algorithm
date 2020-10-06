package tree.检验二叉搜索树_98;

import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索
// 👍 794 👎 0
public class Solution {
    //Time:O(n)     Space:O(n)
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTBound(root, null, null);
    }
    //思路
    //递归    深度优先
    //  对于任意节点，设置上界和下界

    private boolean isValidBSTBound(TreeNode node, TreeNode low, TreeNode up) {
        if (node == null) return true;
        if (low != null && low.val >= node.val) return false;
        if (up != null && up.val <= node.val) return false;
        return isValidBSTBound(node.left, low, node) && isValidBSTBound(node.right, node, up);
    }


    //Time:O(nlogn)     Space:O(n)
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        return (root.left == null || max(root.left) < root.val)
                && (root.right == null || min(root.right) > root.val)
                && isValidBST2(root.left) && isValidBST2(root.right);
    }
    //思路
    //递归  深度优先
    //      1.实现获取一个节点左边最小的值
    //      2.实现获取一个节点右边最大的值
    //      3.左<中<右,递归求孩子节点

    private int max(TreeNode node) {
        while (node.right != null) node = node.right;
        return node.val;
    }

    private int min(TreeNode node) {
        while (node.left != null) node = node.left;
        return node.val;
    }

    //Time:O(n)     Space:O(n)
    public static boolean isValidBSTInOrder(TreeNode root) {
        if (root == null) return true;
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(root, list);

        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1 && list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }

    //思路
    //递归 深度优先
    //中序遍历，借助数组保存值，数组是递增的则代表是搜索二叉树
    private static void inOrderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrderTraverse(root.left, list);
        list.add(root.val);
        inOrderTraverse(root.right, list);
    }

}
