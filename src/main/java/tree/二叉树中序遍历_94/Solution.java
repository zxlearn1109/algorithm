package tree.二叉树中序遍历_94;
//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 736 👎 0


import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

    //Time:O(n)     Space:O(n)
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) return Collections.EMPTY_LIST;

        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                resultList.add(pop.val);
                if (pop.right != null) root = pop.right;
            }
        }
        return resultList;
    }
    //思路
    //迭代    深度优先
    //用栈结构先进后出的特性，左中右遍历所有结点


    //Time:O(n)     Space:O(logn)
    public List<Integer> inorderTraversalRecur(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<Integer> list = new ArrayList<>();
        inorderTraversalRecur(root, list);
        return list;
    }

    public void inorderTraversalRecur(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversalRecur(node.left, list);
        list.add(node.val);
        inorderTraversalRecur(node.right, list);
    }

    //思路
    //递归 深度优先
    //  1.构造结果集resultlist
    //  2.递归搜索当前节点的左子树、将当前节点的值加入结果集、递归搜索当前节点的右子树

}
