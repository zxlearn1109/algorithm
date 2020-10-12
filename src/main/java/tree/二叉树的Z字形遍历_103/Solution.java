package tree.二叉树的Z字形遍历_103;
//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层次遍历如下：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 279 👎 0

import tree.structure.TreeNode;

import java.util.*;

public class Solution {
    //TIME:O(n)     Space:O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> resultList = new ArrayList<>();
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (reverse) {
                    list.add(0, node.val);
                } else list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            reverse = !reverse;
            resultList.add(list);
        }

        return resultList;
    }

}
