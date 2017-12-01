package miles;

import com.sun.corba.se.pept.transport.ListenerThread;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 创建二叉树（输入：数组、字符串）
 */
public class BuildTree {

    public TreeNode getRoot() {
        return root;
    }

    private TreeNode root;

    public BuildTree() {
    }

    /**
     * 通过字符串创建二叉树，字符串格式为："1,2,#,4,5.."，其中","为分隔符，"#"表示当前结点为空
     * @param treeStr
     * @return
     */
    public TreeNode buildTree(String treeStr){
        if (treeStr==null || "".equals(treeStr))
            throw new IllegalArgumentException("字符串为空！无法构建二叉树！");
        String[] nodeStrs = treeStr.split(",");
        root = buildTree(nodeStrs,0);
        return root;
    }

    /**
     * 通过数组创建二叉树（层序）
     * @param array
     * @return
     */
    public TreeNode buildTree(int[] array){
        if (array==null)
            throw new IllegalArgumentException("数组为空！无法构建二叉树！");
        if (array.length==0)
            return null;
        root = buildTree(array,0);
        return root;
    }

    public TreeNode buildTree(int[] array,int index){
        TreeNode node = null;
        if (index<array.length){
            node = new TreeNode(array[index]);
            node.left = buildTree(array,2*index+1);
            node.right = buildTree(array,2*index+2);
        }
        return node;
    }

    public TreeNode buildTree(String[] nodeStrs,int index){
        TreeNode node = null;
        if (index<nodeStrs.length){
            if (!"#".equals(nodeStrs[index])){
                node = new TreeNode(Integer.parseInt(nodeStrs[index]));
                node.left = buildTree(nodeStrs,2*index+1);
                node.right = buildTree(nodeStrs,2*index+2);
            }else
                return null;
        }
        return node;
    }

    /**
     * 层序遍历
     * @param root
     * @return：遍历结果为N个数组，N为二叉树的长度，每个数组包含了二叉树中某一行所有的节点的值
     */
    public List<List<Integer>> accessByLayer(TreeNode root){
        if (root==null)
            new ArrayList<>();
        //两个队列分别用来保存某相邻两层的节点
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<List<Integer>> treeList = new ArrayList<>();
        queue1.offer(root);
        printOneRow(queue1,queue2,treeList);
        return treeList;
    }
    public void printOneRow(Queue<TreeNode> father,Queue<TreeNode> son,List<List<Integer>> treeList){
        //如果这一层队列为空，则说明到底了
        if (father.isEmpty())
            return;
        ArrayList<Integer> layer = new ArrayList<>();     //输出一整层
        //将father代表的该层的所有节点输出，并且将该层的所有孩子加入到son队列
        while (!father.isEmpty()){
            TreeNode node = father.poll();
            layer.add(node.val);
            if (node.left!=null)
                son.offer(node.left);
            if (node.right!=null)
                son.offer(node.right);
        }
        treeList.add(layer);      //将该层输出结果加入到tree中
        printOneRow(son,father,treeList);    //交换father和son的位置，
        // son变成下一次递归函数的“当前层”，father变成下一次递归函数的“下一层”
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (root==null)
            return "tree is empty!";
        //按层序遍历
        List<List<Integer>> treeList = accessByLayer(root);
        if (treeList.isEmpty())
            return "tree is empty!";
        for (List<Integer> layer:treeList){
            for (int nodeVal:layer){
                stringBuilder.append(nodeVal+",");
            }
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("\r\n");
        return stringBuilder.toString();
    }

    public int run(TreeNode root) {
        if (root==null)
            return 0;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        return accessByLayer(queue1,queue2,1);
    }

    public int accessByLayer(Queue<TreeNode> father,Queue<TreeNode> son,int deep){
        if (father.isEmpty())
            return deep;
        while (!father.isEmpty()){
            TreeNode node = father.poll();
            //检查node是否是叶子节点
            if (node.left==null && node.right==null)
                return deep;
            if (node.left!=null){
                son.offer(node.left);
            }if (node.right!=null){
                son.offer(node.right);
            }
        }
        return accessByLayer(son,father,deep+1);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        String nodeStrs = "1,2,5,3,4";
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(array);
        int deep = buildTree.run(buildTree.root);
        System.out.println("min_deep:"+deep);
    }
}
