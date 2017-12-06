package miles.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * populating-next-right-pointers-in-each-node
 * 输入一棵树，节点的next属性为null，但是需要将next指向该节点右边的节点（不一定是兄弟节点）
 */
public class NextRightBother {
    public void connect(TreeLinkNode root) {
        if (root==null)
            return;
        Queue<TreeLinkNode> queue1 = new LinkedList<>();
        Queue<TreeLinkNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        setRightBother(queue1,queue2);
    }

    public void setRightBother(Queue<TreeLinkNode> father,Queue<TreeLinkNode> son){
        if (father.isEmpty())
            return;
        while (!father.isEmpty()){
            TreeLinkNode node = father.poll();
            TreeLinkNode nextNode = father.peek();  //该节点同一层的下一个节点，
            // 注意这里peek()函数只是获得队列的下一个节点，但是没有进行出队操作
            node.next = nextNode;   //将该节点的next指向下一个节点（没有的话就是null）
            if (node.left!=null)
                son.offer(node.left);
            if (node.right!=null)
                son.offer(node.right);
        }
        setRightBother(son,father);
    }

    public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
    }
}
