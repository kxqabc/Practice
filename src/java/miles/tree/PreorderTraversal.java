package miles.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历二叉树
 */
public class PreorderTraversal {

    private List<Integer> list = new ArrayList<>();

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        preorder(root);
        return (ArrayList<Integer>) list;
    }

    public TreeNode preorder(TreeNode root){
        if (root==null)
            return null;
        list.add(root.val);
        TreeNode left = preorder(root.left);
        TreeNode right = preorder(root.right);
        return root;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        TreeNode root = TreeNode.buildTree(array);
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        preorderTraversal.preorderTraversal(root);
        for (int val:preorderTraversal.list)
            System.out.printf(val+" ");
    }
}
