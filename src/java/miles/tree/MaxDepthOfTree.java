package miles.tree;

import java.util.ArrayList;

/**
 * maximum-depth-of-binary-tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepthOfTree {

    private int maxDepth;

    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        setMaxDepth(root,1);
        return maxDepth;
    }

    public void setMaxDepth(TreeNode root,int depth){
        if (root==null)
            return;
        maxDepth = depth>maxDepth?depth:maxDepth;
        setMaxDepth(root.left,depth+1);
        setMaxDepth(root.right,depth+1);
    }

    public static void main(String[] args) {
        String treeStr = "1";
        TreeNode root = TreeNode.buildTree(treeStr);
        MaxDepthOfTree maxDepthOfTree = new MaxDepthOfTree();
        maxDepthOfTree.maxDepth(root);
        System.out.println("maxDepth: "+maxDepthOfTree.maxDepth);
        ArrayList<Integer> arrayList = new ArrayList<>();

    }
}
