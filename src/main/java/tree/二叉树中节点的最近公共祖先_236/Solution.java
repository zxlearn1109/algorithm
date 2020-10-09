package tree.二叉树中节点的最近公共祖先_236;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
//
// 示例 2:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
//
// Related Topics 树
// 👍 779 👎 0

import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //Time:O(n)     Space:O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        List<TreeNode> plist = new ArrayList<>();
        List<TreeNode> qlist = new ArrayList<>();
        searchPath(root, p, plist);
        searchPath(root, q, qlist);

        int i = 0, len = Math.min(plist.size(), qlist.size());
        while (i < len && plist.get(i).equals(qlist.get(i))) i++;
        return plist.get(i - 1);
    }
    //思路
    //递归    深度优先
    //查询根节点root到p、q的路径，然后找出路径中最后一个相同的值

    private boolean searchPath(TreeNode root, TreeNode node, List<TreeNode> list) {
        if (root == null) return false;
        list.add(root);
        if (root.equals(node)) return true;
        boolean search = searchPath(root.left, node, list) || searchPath(root.right, node, list);
        if (search) return true;
        list.remove(list.size() - 1);
        return false;
    }

}
