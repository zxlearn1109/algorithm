package tree.用1至n生成二叉搜索树_95;
//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
//
//
//
// 示例：
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
//
//
//
// 提示：
//
//
// 0 <= n <= 8
//
// Related Topics 树 动态规划
// 👍 672 👎 0

import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return Collections.EMPTY_LIST;
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int low, int high) {
        if (low > high) return Collections.singletonList(null);
        if (low == high) return Collections.singletonList(new TreeNode(low));

        List<TreeNode> resultList = new ArrayList<>();

        for (int i = low; i <= high; i++) {
            List<TreeNode> lefts = generateTrees(low, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, high);
            for (TreeNode right : rights) {
                for (TreeNode left : lefts) {
                    TreeNode root = new TreeNode(i);
                    root.left = cloneTree(left);
                    root.right = cloneTree(right);
                    resultList.add(root);
                }
            }
        }
        return resultList;
    }

    private TreeNode cloneTree(TreeNode node) {
        if (node == null) return node;
        TreeNode copy = new TreeNode(node.val);
        copy.left = cloneTree(node.left);
        copy.right = cloneTree(node.right);
        return copy;
    }

}
