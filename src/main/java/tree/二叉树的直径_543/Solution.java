package tree.二叉树的直径_543;
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
// 示例 :
//给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
// Related Topics 树
// 👍 508 👎 0

import tree.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    //Time:O(n)     Space:O(n)
    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> depthMap = new HashMap<>();
        int maxDepth = 0;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode peek = stack.peek();
            if (peek.right == null || depthMap.containsKey(peek.right)) {
                depthMap.put(peek,
                        Math.max(depthMap.getOrDefault(peek.left, 0),
                                depthMap.getOrDefault(peek.right, 0)) + 1);
                maxDepth = Math.max(maxDepth,
                        depthMap.getOrDefault(peek.left, 0) + depthMap.getOrDefault(peek.right, 0));
                stack.pop();
            } else node = peek.right;
        }
        return maxDepth;
    }
    //思路
    //中左右顺序遍历，存储每个节点的最大深度，经过每个节点的最长路径为其左子树最大深度+其右子树最大深度

    //Time:O(n)     Space:O(n)
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] d = new int[1];
        maxDepth(root, d);
        return d[0];
    }
    //思路
    //经过某个节点的最大直径长度=最大的左子树高度+最大的右子树高度  取所有结点最大的值

    private int maxDepth(TreeNode root, int[] d) {
        if (root == null) return 0;
        int left = maxDepth(root.left, d);
        int right = maxDepth(root.right, d);
        d[0] = Math.max(d[0], left + right);
        return Math.max(left, right) + 1;
    }


}
