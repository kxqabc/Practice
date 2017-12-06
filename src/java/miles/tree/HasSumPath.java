package miles.tree;

/**
 * path-sum
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 在一颗二叉树中判断是否存在一条从根节点到叶子节点的路径，使得路径上节点值的综合等于给定的sum。
 */
public class HasSumPath {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)
            return false;
        sum = sum - root.val;
        if (sum==0 && root.left==null && root.right==null)
            return true;
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        TreeNode root = TreeNode.buildTree(array);
        HasSumPath hasSumPath = new HasSumPath();
        boolean hasPath = hasSumPath.hasPathSum(root,100);
        System.out.println("has sum path?"+hasPath);
    }
}
