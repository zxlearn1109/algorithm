package tree.二叉树的序列化和反序列化_297;
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。
//
// 示例:
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]"
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
// Related Topics 树 设计
// 👍 376 👎 0


import tree.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        System.out.println(serialize(root));

        System.out.println(serialize2(root));
        System.out.println(deserialize(serialize(root)).equals(root));
    }

    public static String serialize2(TreeNode root) {
        if (root == null) return "[]";
        List<TreeNode> trees = new ArrayList<>();
        trees.add(root);
        for (int i = 0; i < trees.size(); ++i) {
            TreeNode node = trees.get(i);
            if (node != null) {
                trees.add(node.left);
                trees.add(node.right);
            }
        }
        while (trees.get(trees.size() - 1) == null)
            trees.remove(trees.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trees.size() - 1; ++i) {
            String str = trees.get(i) == null ? "null" : String.valueOf(trees.get(i).val);
            sb.append(str).append(',');
        }
        return "[" + sb.append(trees.get(trees.size() - 1).val).toString() + "]";
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return null;

        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            stringBuilder.append(node == null ? "null," : node.val + ",");
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.equals("")) return null;
        String[] split = data.split(",");
        int len = split.length;
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (split[i].equals("null")) {
                list.add(null);
            } else
                list.add(new TreeNode(Integer.valueOf(split[i])));
        }

        int move = 1;
        for (int i = 0; i < len; i++) {
            TreeNode node = list.get(i);
            if (node == null) continue;
            if (move < len) node.left = list.get(move++);
            if (move < len) node.right = list.get(move++);

        }

        return list.get(0);
    }

}
