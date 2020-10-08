package tree.用前序和中序遍历序列构建二叉树_105;
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 705 👎 0


import tree.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //Time:O(n)     Space:O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inPosMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inPosMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inPosMap);
    }
    //思路
    //递归    深度优先
    //      1.缓存中序遍历数组每个元素的idx
    //      2.根据前序遍历数组和inPosMap构建树
    //          2.1:构建根节点（前序遍历第一个是根节点）
    //          2.2:构建左子树
    //          2.3:构建右子树

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, Map<Integer, Integer> inPosMap) {
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIdx = inPosMap.get(preorder[preStart]);
        root.left = buildTree(preorder, preStart + 1, preStart + inIdx - inStart,
                inorder, inStart, inPosMap);
        root.right = buildTree(preorder, preStart + inIdx - inStart + 1, preEnd, inorder, inIdx + 1, inPosMap);
        return root;
    }
}
