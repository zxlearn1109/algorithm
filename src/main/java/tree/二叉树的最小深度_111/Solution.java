package tree.二叉树的最小深度_111;
//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 377 👎 0


import tree.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {

    //Time:O(n)     Space:O(n)
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return depth;
    }

    //思路
    //迭代   广度优先
    //      1.借助结构queue和指针size获取每层所有的节点
    //      2.每操作一层结构，depth+1
    //      3.queue中的节点为叶子节点，直接返回高度，若不为叶子节点，将其孩子节点加入queue中

    //Time:O(n)     Space:O(n)  average:O(logn)
    public int minDepthRecur(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left != null && root.right != null)
            return Math.min(minDepthRecur(root.left), minDepthRecur(root.right)) + 1;
        if (root.left != null) return minDepthRecur(root.left) + 1;
        return minDepthRecur(root.right) + 1;
    }

    //思路:
    //递归
    //      1.节点为空，高度为0
    //      2.节点为叶子节点，高度为1
    //      3.节点左右不为空，求左右节点的最低高度+1
    //      4.求孩子节点不为空的高度+1
}
