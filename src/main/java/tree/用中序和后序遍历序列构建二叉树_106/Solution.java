package tree.用中序和后序遍历序列构建二叉树_106;
//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 383 👎 0

import tree.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //Time:O(n)     Space:O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            posMap.put(inorder[i], i);
        }

        return buildTree(0, postorder,
                0, postorder.length - 1, posMap);
    }
    //思路
    //递归    深度优先
    //      1.缓存中序遍历数组每个元素的idx
    //      2.根据后序遍历数组和inPosMap构建树
    //          2.1:构建根节点（后序遍历第一个是根节点）
    //          2.2:构建左子树
    //          2.3:构建右子树

    private TreeNode buildTree(int inStart, int[] postorder,
                               int postStart, int postEnd,
                               Map<Integer, Integer> posMap) {
        if (postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = posMap.get(postorder[postEnd]);
        root.left = buildTree(inStart,
                postorder, postStart, postStart + idx - inStart - 1,
                posMap);
        root.right = buildTree(idx + 1, postorder, postStart + idx - inStart, postEnd - 1, posMap);

        return root;
    }
}
