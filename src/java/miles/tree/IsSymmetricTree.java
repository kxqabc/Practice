package miles.tree;

/**
 * symmetric-tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 判断一棵二叉树是否是对称的
 */
public class IsSymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        //输入参数是重点
        return checkIsMirror(root,root);
    }

    /**
     * 函数的两个输入参数是关键，一次要判断两个节点是否相等，所以最好是两个参数
     * @param left
     * @param right
     * @return
     */
    public boolean checkIsMirror(TreeNode left,TreeNode right){
        if (left==null && right==null)
            return true;
        if ((left==null && right!=null) || (left!=null && right==null))
            return false;
        return left.val==right.val &&
                checkIsMirror(left.left,right.right) &&
                checkIsMirror(right.left,left.right);
    }
}
