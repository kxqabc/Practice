package miles.tree;

import java.util.HashMap;

/**
 * validate-binary-search-tree
 * 判断一棵二叉树是否为 搜索二叉树
 */
public class IsBSTTree {

    private int pre = Integer.MIN_VALUE;    //表示当前节点的前面一个节点的大小
    private boolean isBST = true;   //判断是否是BST的标志位

    public boolean isValidBST(TreeNode root) {
        if (root==null)
            return true;
        inorderSearch(root);
        return isBST;
    }

    /**
     * 利用中序遍历，已知搜索二叉树的中序遍历的结果为一个一次增大的队列，若不符合则不是有效的搜索二叉树
     * @param root
     */
    public void inorderSearch(TreeNode root){
        if (root==null)
            return;
        inorderSearch(root.left);
        //如果当前节点的值不大于前一节点，则不是BST
        if (root.val<=pre){
            isBST = false;
            return;
        }
        //将当前节点的值保存到pre中，作为下一个节点的前驱节点值
        pre = root.val;
        inorderSearch(root.right);
    }

    public static void main(String[] args) {
        String treeStr = "4,2,#,1,3";
        TreeNode root = TreeNode.buildTree(treeStr);
        IsBSTTree isBSTTree = new IsBSTTree();

    }

}
