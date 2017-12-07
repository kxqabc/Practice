package miles.tree;

import java.util.ArrayList;

/**
 * path-sum-ii
 *Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 与题目：path-sum不同之处在于：这里要求找出二叉树中的所有符合条件的路径（从根节点至叶子节点）。
 */
public class HasSumPaths {

    private ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null)
            return new ArrayList<>();
        hasPathSum(root,sum,new ArrayList<>());
        return allPath;
    }

    /**
     * 前序遍历
     * @param root
     * @param sum
     * @param valPath
     */
    public void hasPathSum(TreeNode root, int sum,ArrayList<Integer> valPath) {
        if (root==null)
            return;
        //将该节点的值加入到路径中
        valPath.add(root.val);
        sum = sum - root.val;
        //路径和等于sum且该节点为叶子节点
        if (sum==0 && root.left==null && root.right==null){
            System.out.println("找到一条路径："+valPath);
            allPath.add(new ArrayList<>(valPath));
            return;
        }
        hasPathSum(root.left,sum,new ArrayList<>(valPath)); //这里注意用new创建一个新的list，否则迭代后的函数会影响此引用
        hasPathSum(root.right,sum,new ArrayList<>(valPath));
    }

    @Override
    public String toString() {
        return "HasSumPaths{" +
                "allPath=" + allPath +
                '}';
    }

    public static void main(String[] args) {
//        int[] array = {5,4,8,11,13,4,7,2};
        String elements = "5,4,8,11,#,13,4,7,2,#,#,#,#,5,1";
        TreeNode root = TreeNode.buildTree(elements);
        HasSumPaths hasSumPaths = new HasSumPaths();
        hasSumPaths.pathSum(root,22);
        System.out.println(hasSumPaths.toString());
    }

}
