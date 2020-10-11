package tree.二叉树中的所有路径_257;
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
// 👍 383 👎 0


import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //Time:O(n * log(n))       Space:O(n)
    public List<String> binaryTreePathsV2(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePathsv2(root, result, new StringBuilder());
        return result;
    }
    //思路
    //递归    深度优先
    //采用dfs思想，声明结果集result和记录过程中生成的到叶子节点路径stringBuilder..
    //1.终止条件 : 节点为null，结束
    //2.如果节点为叶子节点，将路径保存到结果集中，否则stringBuidler添加后缀"->"
    //3.递归求左右子树。之后回溯到上一层节点，还原路径stringBuidler
    //String 和StringBuidler的区别，String拼接字符会对拼接字符串进行拷贝连接O(n)复杂度，Stringbuidler只需要O(1)

    private void binaryTreePathsv2(TreeNode root, List<String> result, StringBuilder stringBuilder) {
        if (root == null) return;
        int len = stringBuilder.length();
        stringBuilder.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(stringBuilder.toString());
        } else {
            stringBuilder.append("->");
        }
        binaryTreePathsv2(root.left, result, stringBuilder);
        binaryTreePathsv2(root.right, result, stringBuilder);
        stringBuilder.setLength(len);
    }

    //Time:O(n^2)       Space:O(n^2)
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, result, "");
        return result;
    }

    private void binaryTreePaths(TreeNode root, List<String> result, String str) {
        if (root == null) return;
        str += root.val;
        if (root.left == null && root.right == null) {
            result.add(str);
            return;
        }
        str += "->";
        binaryTreePaths(root.left, result, str);
        binaryTreePaths(root.right, result, str);
    }

}
