package tree.二叉树中和为给定值的路径数量_437;
//给定一个二叉树，它的每个结点都存放着一个整数值。
//
// 找出路径和等于给定数值的路径总数。
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
//
// 示例：
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
//
// Related Topics 树
// 👍 607 👎 0

import tree.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Time: O(n), Space: O(n)
    public int pathSum2(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        return dfs(root, 0, sum, map);
    }

    //思路
    //递归    深度优先
    //前缀和:1.两个节点的前缀和相等，则两个节点之间的路径和为0
    //      2.两个节点的前缀和之差等于两个节点之间的路径和
    //本题求二叉树中任意节点开始路径和为给定节点的路径个数    求任意节点开始，且非叶子节点结束的路径和为给定值都可以套用前缀和思路
    //前序遍历，采用map保存有效的前缀和，当前前缀和-sum若在map中存在，则说明存在有效路径。有效路径个数为map中前缀路径和的value数

    private int dfs(TreeNode root, int cur, int sum, Map<Integer, Integer> map) {
        if (root == null) return 0;
        cur += root.val;
        int cnt = map.getOrDefault(cur - sum, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        cnt += dfs(root.left, cur, sum, map);
        cnt += dfs(root.right, cur, sum, map);
        map.put(cur, map.getOrDefault(cur, 0) - 1);

        return cnt;
    }

    //Time:O(n^2)   Space:O(n)
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumRecur(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumRecur(TreeNode root, int sum) {
        if (root == null) return 0;
        int result = 0;
        if (root.val == sum) result++;
        return result + pathSumRecur(root.left, sum - root.val) + pathSumRecur(root.right, sum - root.val);
    }

}
