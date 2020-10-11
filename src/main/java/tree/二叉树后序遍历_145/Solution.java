package tree.二叉树后序遍历_145;
//给定一个二叉树，返回它的 后序 遍历。
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
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 458 👎 0

import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

    //Time:O(n)     Space:O(n)
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        Stack<TreeNode> reverse = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            reverse.push(node);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        List<Integer> resultList = new ArrayList<>();
        while (!reverse.isEmpty()) resultList.add(reverse.pop().val);
        return resultList;
    }
    //前序遍历：中左右  后序遍历:左右中    对后续遍历结果进行反转:中右左   可得:只要把前序遍历的左右节点换一下顺序即可

    //Time:O(n)     Space:O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.peek();
            if (node.right == null || node.right.equals(prev)) {
                TreeNode pop = stack.pop();
                resultList.add(pop.val);
                prev = pop;
            } else root = node.right;
        }
        return resultList;
    }

    //Time:O(n)     Space:O(n)
    public List<Integer> postorderTraversalRecur(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        postorderTraversalRecur(root, resultList);
        return resultList;
    }

    private void postorderTraversalRecur(TreeNode root, List<Integer> resultList) {
        if (root == null) return;
        postorderTraversalRecur(root.left, resultList);
        postorderTraversalRecur(root.right, resultList);
        resultList.add(root.val);
    }

}
