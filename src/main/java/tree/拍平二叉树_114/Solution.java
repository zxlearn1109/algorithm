package tree.拍平二叉树_114;
//给定一个二叉树，原地将它展开为一个单链表。
//
//
//
// 例如，给定二叉树
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6
//
// 将其展开为：
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// Related Topics 树 深度优先搜索
// 👍 576 👎 0

import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //Time:O(n)     Space:O(n)
    private TreeNode prev;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
    //思路
    //递归    深度优先
    //定义fc函数，函数定义：拍平二叉树
    //函数变量:root    f(root.left)     f(root.right)
    //注释例子:1        2-》3-》4         5-》6
    //观察可得：每个节点的左指针设置为null，root右指针指向f(root.left),f(root.left)的叶子节点4的右子针指向f(root.right)即可
    //获取f(root.left)的叶子节点是一个O（logn）操作，可以通过右左中的自底向上的遍历顺序处理，保留上一次处理的根节点为prev。相当于先拍平5，prev指向5，再拍平4，4的right指针指向5


    //Time:O(nlogn)     Space:O(n)
    public void flatten2(TreeNode root) {
        if (root == null) return;

        flatten2(root.left);
        flatten2(root.right);

        if (root.left != null) {
            TreeNode right = root.right;
            TreeNode left = root.left;
            root.left = null;
            root.right = left;
            if (right != null) {
                while (left.right != null) left = left.right;
                left.right = right;
            }
        }
    }
    //思路
    //递归    深度优先
    //1.先拍平左子树、再拍平右子树
    //2.如果左子树为空不处理
    //3.获取左子树left和右子树right，根节点left指针置为null，根节点right指针指向left。
    //4.如果right为null不处理，否则获取left上最右的节点，left.right = right;
    //获取left最右的节点，对于遍历logn次

    //Time:O(n)     Space:O(n)
    public void flattenIter(TreeNode root) {
        if (root == null) return;
        List<Integer> nodeList = new ArrayList<>();
        preOrder(root, nodeList);
        for (int i = 1; i < nodeList.size(); i++) {
            root.left = null;
            root.right = new TreeNode(nodeList.get(i));
            root = root.right;
        }
    }
    //思路
    //递归    深度优先
    //前序遍历保存结果，重新构造二叉树

    private void preOrder(TreeNode root, List<Integer> nodeList) {
        if (root == null) return;
        nodeList.add(root.val);
        preOrder(root.left, nodeList);
        preOrder(root.right, nodeList);
    }
}
