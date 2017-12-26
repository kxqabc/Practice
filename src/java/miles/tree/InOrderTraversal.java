package miles.tree;


import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {

    private ArrayList<Integer> inorderArray = new ArrayList<>();

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        inorder(root);
        return inorderArray;
    }

    public void inorder(TreeNode root){
        if (root==null)
            return;
        inorder(root.left);
        inorderArray.add(root.val);
        inorder(root.right);
    }

    /**
     * 非递归方法中序遍历
     * @param node
     */
    public void inorderByStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || node!=null){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()){
                node = stack.pop();
                inorderArray.add(node.val);
                node = node.right;
            }
        }

    }

    @Override
    public String toString() {
        return "InOrderTraversal{" +
                "inorderArray=" + inorderArray +
                '}';
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree("1,#,2");
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.inorderTraversal(root);
        System.out.println(inOrderTraversal.toString());
    }
}
