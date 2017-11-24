package miles;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到**叶结点**所经过的结点形成一条路径。
 */
public class FindPath {

    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();    //保存所有的路径

    private ArrayList<Integer> path = new ArrayList<>();    //其中一条路径

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        return deepSerach(root,target);
    }

    public ArrayList<ArrayList<Integer>> deepSerach(TreeNode root,int target){
        if (root == null)
            return paths;
        path.add(root.val); //首先将当前节点加入path
        target = target - root.val;
        //当target为0，并且当前节点是叶子节点时，将path添加到paths中，但是注意要new一个新的数列，将path传入
        if (target==0 && root.left==null && root.right==null)
            paths.add(new ArrayList<>(path));   //不能直接添加path，否则后面path被修改会影响到paths中的path引用
        deepSerach(root.left,target);
        deepSerach(root.right,target);
        path.remove(path.size()-1);     //考察完当前节点要退出函数时，把当前节点从path中删除。
        return paths;
    }
    public void test(){
        path.add(1);
        paths.add(path);
        for (int i:path){
            System.out.print(i+" ");
        }
        System.out.println("\r\n"+"********");
        path.remove(path.size()-1);
        for (ArrayList<Integer> path:paths){
            for (int i:path)
                System.out.print(i+" ");
            System.out.print("\r\n");
        }
        System.out.println("\r\n"+"********");
    }

    public TreeNode createTree(int[] array,int index){
        if (index >= array.length)
            return null;
        TreeNode node = new TreeNode(array[index]);
        node.left = createTree(array,2*index+1);
        node.right = createTree(array,2*index+2);
        return node;
    }

    public void printTree(TreeNode root){
        if (root!=null){
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        FindPath findPath = new FindPath();
        int[] array = {1,2,3,4,5,6};
        findPath.test();
    }
}
