package tree.二叉树的层序遍历_102;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索
// 👍 662 👎 0


import tree.structure.TreeNode;

import java.util.*;

public class Solution {

    //Time:O(n)     Space:O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {

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

        return resultList;
    }

    //思路
    //宽度优先  迭代
    //借助queue先进先出的特性对每层节点进行保存,节点有孩子节点的话则将其加入到队列中
}
