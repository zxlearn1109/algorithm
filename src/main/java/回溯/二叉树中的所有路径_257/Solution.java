package 回溯.二叉树中的所有路径_257;
//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索
// 👍 387 👎 0

import tree.structure.TreeNode;

import java.util.*;

public class Solution {

    //Time:O(n * log(n)) Space:O(n)
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        binaryTreePathsDfsv2(root, path, result);
        return result;
    }
    //复杂度估算:stringbuidler添加操作复杂度为常量级，toString为相当于将stringbuilder的字符数组拷贝了一份，复杂度为O（n）。
    //最坏情况下，二叉树为满二叉树，路径高度为log n,二叉树哥树为n/2,总的复杂度为O（nlogn）,空间复杂度最坏情况(倾斜情况严重)为O（n）

    private void binaryTreePathsDfsv2(TreeNode root, StringBuilder path, List<String> result) {
        if (root == null) return;
        int len = path.length();
        path.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            binaryTreePathsDfsv2(root.left, path, result);
            binaryTreePathsDfsv2(root.right, path, result);
        }
        path.setLength(len);
    }

    //思路:典型的回溯问题，可选择项，左右子树，当前路径path，终止条件：当前节点为叶子节点，结果result。
    //须注意字符串拼接使用StringBuilder，回溯操作使用setLength();


    private void binaryTreePathsDfs(TreeNode root, StringBuilder path, List<String> result) {
        if (root == null) return;
        path.append(root.val).append("->");
        if (root.left == null && root.right == null) {
            path.setLength(path.length() - 2);
            result.add(path.toString());
            return;
        }
        int len = path.length();
        binaryTreePathsDfs(root.left, path, result);
        path.setLength(len);
        binaryTreePathsDfs(root.right, path, result);
        path.setLength(len);
    }

}
