package tree.structure;

import lombok.Getter;

@Getter
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}
