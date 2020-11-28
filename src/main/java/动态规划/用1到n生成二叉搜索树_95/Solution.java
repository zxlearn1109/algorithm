package 动态规划.用1到n生成二叉搜索树_95;
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
// 👍 711 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return Collections.EMPTY_LIST;
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        if (start > end) return Collections.singletonList(null);
        if (start == end) return Collections.singletonList(new TreeNode(start));

        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    //多个root会共享子树，如有必要再拆分一次
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }

        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
