package tree.structure;

import lombok.Getter;

@Getter
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

}
