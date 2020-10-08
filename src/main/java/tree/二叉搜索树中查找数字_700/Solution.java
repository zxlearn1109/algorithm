package tree.二叉搜索树中查找数字_700;
//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
//
// 例如，
//
//
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
//
//
// 你应该返回如下子树:
//
//
//      2
//     / \
//    1   3
//
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
// Related Topics 树
// 👍 93 👎 0


import tree.structure.TreeNode;

public class Solution {
    //Time:O(n)     Space:O(1)
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) return root;
            root = root.val < val ? root.right : root.left;
        }
        return root;
    }
    //思路
    //迭代    深度优先
    //根据父节点大于左孩子节点小于右孩子节点，移动root指针

    //Time:O(n)     Space:O(n)
    public TreeNode searchBSTRecur(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val > val ? searchBSTRecur(root.left, val) : searchBSTRecur(root.right, val);
    }
    //思路
    //递归    深度优先

}
