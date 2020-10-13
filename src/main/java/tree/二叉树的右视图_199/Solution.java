package tree.二叉树的右视图_199;

import tree.structure.TreeNode;

import java.util.*;
//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 示例:
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
//
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 335 👎 0

public class Solution {

    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;

        List<Integer> resultList = new ArrayList<>();
        dfs(root, resultList, 0);

        return resultList;
    }
    //思路
    //递归    dfs
    //递归过程中保存当前的层数level，以0开始。以中右做的顺序遍历，当level==resultlist.size()说明是最右侧的节点，将当前节点值加入结果集中

    private void dfs(TreeNode root, List<Integer> resultList, int level) {
        if (root == null) return;
        if (level == resultList.size()) resultList.add(root.val);

        dfs(root.right, resultList, level + 1);
        dfs(root.left, resultList, level + 1);
    }

    //Time:O(n)     Space:O(n)
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;

        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            resultList.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
        }

        return resultList;
    }
    //思路
    //迭代  bfs
    //将二叉树的每层节点以从右向左的顺序加入queue，将每层的最后一个节点加入结果集中

}
