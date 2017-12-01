package miles;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.The minimum depth is the number of nodes
 * along the shortest path from the root node down to the nearest leaf node.
 * 给出一个二叉树，找到从根节点到叶子结点的最短路径深度，也即至少经过几个节点？
 */
public class GetMinDeepInTree {

    public GetMinDeepInTree() {
    }

    public int run(TreeNode root) {
        if (root==null)
            return 0;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        return accessByLayer(queue1,queue2,1);
    }

    /**
     * 按层序遍历的方法，由根节点开始向下一层层搜索，访问到的第一个"叶子节点"时就是二叉树"从根节点到叶子结点的最近的深度"
     * @param father
     * @param son
     * @param deep
     * @return
     */
    public int accessByLayer(Queue<TreeNode> father,Queue<TreeNode> son,int deep){
        if (father.isEmpty())
            return deep;
        while (!father.isEmpty()){
            TreeNode node = father.poll();
            //检查node是否是叶子节点
            if (node.left==null && node.right==null)
                return deep;
            //如果有左右孩子树，则放入另一个队列中
            if (node.left!=null){
                son.offer(node.left);
            }if (node.right!=null){
                son.offer(node.right);
            }
        }
        return accessByLayer(son,father,deep+1);    //deep+1,遍历完一层，开始遍历下一层
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
