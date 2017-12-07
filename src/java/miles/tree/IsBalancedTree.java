package miles.tree;

/**
 *  balanced-binary-tree
 *  Given a binary tree, determine if it is height-balanced.For this problem, a height-balanced binary tree is defined as a binary tree in which the depth
 *  of the two subtrees of every node never differ by more than 1.
 */
public class IsBalancedTree {

    /**
     * 属于前序遍历，先得出左右子树的深度，计算出当前结点是否平衡，若平衡则一次为左右孩子节点调用该函数
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        int left = getDepthOfSon(root.left);
        int right = getDepthOfSon(root.right);
        if (Math.abs((left-right))>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 获取当前节点子树的深度，后续？
     * @param root
     * @return
     */
    public int getDepthOfSon(TreeNode root){
        if (root==null)
            return 0;
        int left = getDepthOfSon(root.left)+1;  //这里的“+1”是关键，表示加上了下面一层（root.left）
        int right = getDepthOfSon(root.right)+1;
        return left>right?left:right;   //返回左右子树中的深度的较大者
    }
}
