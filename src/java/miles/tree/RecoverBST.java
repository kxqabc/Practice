package miles.tree;

/**
 * recover-binary-search-tree
 *  Two elements of a binary search tree (BST) are swapped by mistake.
 *  Recover the tree without changing its structure.
 *  一颗**二叉搜索树**其中的两个节点的值发生了错误的交换，要求在不改变二叉树的结构的情况下恢复搜索二叉树。
 */
public class RecoverBST {
    private TreeNode firstError = null;
    private TreeNode secondError = null;
    private TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        if (root==null)
            return;
        inorderSearch(root);
        if (firstError==null||secondError==null)
            return;
        //交换两个错误节点的值
        int temp;
        temp = firstError.val;
        firstError.val = secondError.val;
        secondError.val = temp;
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inorderSearch(TreeNode root){
        if (root==null)
            return;
        //中序遍历
        inorderSearch(root.left);
        //如果前一个节点不小于当前节点，说明有地方出错
        if (preNode.val>=root.val){
            if (firstError==null){
                //找到了第一个错误点
                firstError = preNode;
                //默认两个错误点相邻，以后如果还能找到错误点可以更改secondError
                secondError = root;
            }
            else
                secondError = root;
        }
        //将前一个节点设为当前节点
        preNode = root;
        inorderSearch(root.right);
    }
}
