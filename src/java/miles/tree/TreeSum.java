package miles.tree;


public class TreeSum {

    public int sumNumbers(TreeNode root) {
        if (root==null)
            return 0;
        return preorderSum(root,0);
    }

    public int preorderSum(TreeNode node,int sum){
        if (node==null)
            return 0;
        //这一层的节点加上上一层乘以10
        sum = sum*10 + node.val;
        if (node.left==null && node.right==null){
            return sum;
        }
        int left = preorderSum(node.left,sum);
        int right = preorderSum(node.right,sum);
        return left+right;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        TreeNode root = TreeNode.buildTree(array);
        TreeSum treeSum = new TreeSum();
        int sum = treeSum.sumNumbers(root);
        System.out.println("sum:"+sum);
    }
}
