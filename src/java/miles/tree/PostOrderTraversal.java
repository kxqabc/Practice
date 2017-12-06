package miles.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历二叉树
 */
public class PostOrderTraversal {

    private List<Integer> list = new ArrayList<>();

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        postOrder(root);
        list.add(root.val);
        return (ArrayList<Integer>) list;
    }

    public TreeNode postOrder(TreeNode root){
        if (root==null)
            return null;

        TreeNode left = postOrder(root.left);
        if (left!=null)
            list.add(left.val);

        TreeNode right = postOrder(root.right);
        if (right!=null)
            list.add(right.val);

        return root;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
