package miles.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * binary-tree-zigzag-level-order-traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * “之”字型按层打印打印二叉树
 */
public class ZigzagOrderPrintTree {

    private boolean flag = false;   //每行的打印顺序不同
    private Queue<TreeNode> queue = new LinkedList<>();     //保存一行的节点
    private ArrayList<ArrayList<Integer>> allRows = new ArrayList<>();      //最终结果
    private Stack<Integer> stack = new Stack<>();       //用来颠倒放入数组的顺序

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        queue.offer(root);
        oneRow(queue);
        return allRows;
    }

    /**
     * 按行遍历，通过一个队列queue保存一行的节点
     * @param queue
     */
    public void oneRow(Queue<TreeNode> queue){
        if (queue.isEmpty())
            return;
        final int queueLength = queue.size();
        ArrayList<Integer> row = null;  //输出的一行打印的节点
        //一行通过stack反响输出，一行直接从队列中取出元素加入数组中，交替进行
        if (flag)
            row = addFromStack(queue,queueLength,new ArrayList<>());
        else
            row = addDirectly(queue,queueLength,new ArrayList<>());
        allRows.add(row);
        //相邻两行反转标志
        flag = !flag;
        //开始遍历下一行
        oneRow(queue);
    }

    /**
     * 通过stack反向输出一行节点
     * @param queue
     * @param length
     * @param arrayList
     * @return
     */
    public ArrayList<Integer> addFromStack(Queue<TreeNode> queue,int length,ArrayList<Integer> arrayList){
        for (int i=0;i<length;i++){
            TreeNode root = queue.poll();
            stack.add(root.val);
            if (root.left!=null)
                queue.offer(root.left);
            if (root.right!=null)
                queue.offer(root.right);
        }
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 从队列中直接输出一行节点
     * @param queue
     * @param length
     * @param arrayList
     * @return
     */
    public ArrayList<Integer> addDirectly(Queue<TreeNode> queue,int length,ArrayList<Integer> arrayList){
        for (int i=0;i<length;i++){
            TreeNode root = queue.poll();
            arrayList.add(root.val);
            if (root.left!=null)
                queue.offer(root.left);
            if (root.right!=null)
                queue.offer(root.right);
        }
        return arrayList;
    }

    @Override
    public String toString() {
        return "ZigzagOrderPrintTree{" +
                "allRows=" + allRows +
                '}';
    }

    public static void main(String[] args) {
        String treeStr = "1,2,3,4,5,6,7,8";
        TreeNode root = TreeNode.buildTree(treeStr);
        ZigzagOrderPrintTree zigzagOrderPrintTree = new ZigzagOrderPrintTree();
        zigzagOrderPrintTree.zigzagLevelOrder(root);
        System.out.println(zigzagOrderPrintTree.toString());
    }

}
