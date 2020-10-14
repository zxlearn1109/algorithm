package tree.二叉树的最大路径和_124;
//给定一个非空二叉树，返回其最大路径和。
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
//
//
//
// 示例 1：
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
//
//
// 示例 2：
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42
// Related Topics 树 深度优先搜索
// 👍 744 👎 0

import tree.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    //Time:O(n)     Space:O(n)
    public int maxPathSum2(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> rootPath = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int maxPath = root.val;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || rootPath.containsKey(root.right)) {
                int leftPath = Math.max(0, rootPath.getOrDefault(root.left, 0));
                int rightPath = Math.max(0, rootPath.getOrDefault(root.right, 0));

                rootPath.put(root, root.val + Math.max(leftPath, rightPath));
                maxPath = Math.max(maxPath, root.val + leftPath + rightPath);
                stack.pop();
                root = null;
            } else root = root.right;
        }

        return maxPath;
    }
    //思路
    //左右中顺序遍历，求自底向上经过当前节点的最大路径值，计算方法:root.val+Math.max(0,Math.max(root.left,root.right));
    //求以当前节点为根节点的最大路径和，计算方法：root.val + Math.max(0,left) + Math.max(0,right)  计算过程中保留最大路径和

    //Time:O(n)     Space:O(n)
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] d = new int[1];
        d[0] = root.val;
        dfs(root, d);
        return d[0];
    }

    private int dfs(TreeNode root, int[] d) {
        if (root == null) return 0;
        int left = dfs(root.left, d);
        int right = dfs(root.right, d);
        int sum = root.val + Math.max(0, left) + Math.max(0, right);
        d[0] = Math.max(sum, d[0]);
        return root.val + Math.max(0, Math.max(left, right));
    }
    //思路
    //dfs   深度优先


}
