package miles.tree;

public class MaxPathSum {
    private int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root==null)
            return 0;
        getMaxPathSum(root);
        return sum;
    }

    /**
     *
     * @param root
     * @return 返回值代表了以输入节点为“根节点”的子树中的最大值（无方向）
     */
    public int getMaxPathSum(TreeNode root){
        if (root==null)
            return 0;
        //获得左右子树的最大路径值，如果最大路径值小于零，就设为零（方便后面求sum）
        int left = Math.max(0,getMaxPathSum(root.left));
        int right = Math.max(0,getMaxPathSum(root.right));
        //root.val+left+right就表示了这个子树的最大路径值，如果这个值大于sum，就更新sum
        sum = Math.max(sum,root.val+left+right);
        return Math.max(0,root.val+Math.max(left,right));
    }



}
