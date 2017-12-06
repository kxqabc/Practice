package miles.tree;

public class ReBuildTree {
    /**
     * 根据前序遍历数组、中序遍历数组重新构造二叉树
     * 1. 通过前序数组可以知道根节点；
     * 2. 通过中序数组可以知道根节点的左右子树
     * 3. 所以具体的思路：通过前序得到根节点，然后在中序获得根节点左边的左子树、右边的右子树；然后再分别对左右子树循环直到只剩叶子。
     * @param pre:前序遍历数组
     * @param in：中序遍历数组
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    public TreeNode reConstructBinaryTree(int [] pre,int preStart,int preEnd,int [] in,int inStart,int inEnd) {
        if (preStart>preEnd || inStart>inEnd)
            return null;
        //前序数组的第一个元素一定是根节点（整棵树或子树）
        TreeNode root = new TreeNode(pre[preStart]);
        int pointcut = 0;   //根节点在中序中的位置
        //计算root节点在中序数组中的位置
        for (int i=inStart;i<=inEnd;i++){
            if (in[i] == pre[preStart]){
                pointcut = i;
                break;
            }
        }
        //pointcut左边的数组则为root节点的左子树，右边的数组为右子树
        //获取左孩子，左孩子在root节点在中序数组中左边的子数组中，但是中序数组无法直接找到一个子树的根节点，所以应该去这个子数组对应的前序中查找她
        root.left = reConstructBinaryTree(pre,preStart+1,preStart+pointcut-inStart,in,inStart,pointcut-1);
        root.right = reConstructBinaryTree(pre,preStart+pointcut-inStart+1,preEnd,in,pointcut+1,inEnd);
        return root;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ReBuildTree reBuildTree = new ReBuildTree();
        int[] a1 = {1,2,4,7,3,5,6};
        int[] a2 = {4,7,2,1,5,3,8,6};
        TreeNode root = reBuildTree.reConstructBinaryTree(a1,a2);
    }
}
