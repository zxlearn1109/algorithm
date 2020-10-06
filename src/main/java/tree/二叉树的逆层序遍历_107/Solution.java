package tree.二叉树的逆层序遍历_107;
//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
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
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索
// 👍 343 👎 0

import tree.structure.TreeNode;

import java.util.*;

public class Solution {

    //Time:O(n)     Space:O(n)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;

        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            resultList.add(list);
        }

        int left = 0, right = resultList.size() - 1;
        while (left <= right) {
            List<Integer> list = resultList.get(left);
            resultList.set(left++, resultList.get(right));
            resultList.set(right--, list);
        }

        return resultList;
    }

    //思路
    //宽度优先  迭代
    //借助queue先进先出的特性对每层节点进行保存,节点有孩子节点的话则将其加入到队列中。将结果list反转
}
