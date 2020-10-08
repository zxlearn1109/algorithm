package tree.翻转二叉树_226;
//翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// 输出：
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// 备注:
//这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
// Related Topics 树
// 👍 649 👎 0


import tree.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //Time:O(n)     Space:O(n)
    public TreeNode invertTree2(TreeNode root) {
        invertTreeRecur(root);
        return root;
    }

    private void invertTreeRecur(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreeRecur(root.left);
        invertTreeRecur(root.right);
    }
    //思路
    //递归    深度优先

    //Time:O(n)     Space:O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    //思路
    //迭代    宽度优先
    //借助队列保存每层的节点，对左右孩子进行交换
}
