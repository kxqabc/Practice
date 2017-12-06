package miles.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintTreeByRow {
    private Queue<TreeNode> queue1 = new LinkedList<>();    //保存一层的节点
    private Queue<TreeNode> queue2 = new LinkedList<>();    //保存相邻下一层的节点
    private ArrayList<ArrayList<Integer>> tree = new ArrayList<>();     //最终输出的结果

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot==null)
            return tree;
        queue1.offer(pRoot);    //首先，将根节点放入代表第一层节点的队列：queue1
        printOneRow(queue1,queue2);
        return tree;
    }

    /**
     * 将每一层节点从左至右添加到列表中
     * @param father：表示当前层，保存了当前层的所有节点（从左至右）
     * @param son：表示下一层，将当前层的所有孩子加入到son中
     */
    public void printOneRow(Queue<TreeNode> father,Queue<TreeNode> son){
        //如果这一层队列为空，则说明到底了
        if (father.isEmpty())
            return;
        ArrayList<Integer> row = new ArrayList<>();     //输出一整层
        //将father代表的该层的所有节点输出，并且将该层的所有孩子加入到son队列
        while (!father.isEmpty()){
            TreeNode node = father.poll();
            row.add(node.val);
            if (node.left!=null)
                son.offer(node.left);
            if (node.right!=null)
                son.offer(node.right);
        }
        tree.add(row);      //将该层输出结果加入到tree中
        printOneRow(son,father);    //交换father和son的位置，
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
}
