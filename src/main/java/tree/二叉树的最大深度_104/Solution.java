package tree.二叉树的最大深度_104;
//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索
// 👍 712 👎 0


import tree.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    //Time:O(n)     Space:O(n),average:O(logn)
    public int maxDepthRecur(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxDepthRecur(root.left), maxDepthRecur(root.right)) + 1;
    }
    //思路
    //递归  深度优先
    //      1.节点为null，高度为0
    //      2.节点为叶子节点，高度为1
    //      3.当前节点的高度为左右孩子节点的最大高度+1


    //Time:O(n)     Space:O(n),average:O(logn)
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }
    //思路
    //迭代    广度优先
    //      1.节点为null，高度为0
    //      2.节点为叶子节点，高度为1
    //      3.只要有孩子节点，就将其加入队列queue中
    //      4.每处理一层节点，depth+1

}
