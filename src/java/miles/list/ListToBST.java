package miles.list;

/**
 * convert-sorted-list-to-binary-search-tree
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next ==null)
            return new TreeNode(head.val);
        //获得链表的中间节点以及其前驱节点
        ListNode preMiddle = getPreMiddle(head);
        ListNode middle = preMiddle.next;
        //设置二叉树的根节点为链表的中间节点
        TreeNode root = new TreeNode(preMiddle.next.val);
        //切断
        preMiddle.next = null;
        //设置左右子树
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);
        return root;
    }

    /**
     * 获取链表的中间节点的前驱，为什么是前驱？为了方便后面从middle点对链表进行剪切
     * @param head
     * @return
     */
    public ListNode getPreMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = head;
        while (fast != null && fast.next!=null){
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return preSlow;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        ListNode head = ListNode.build(array);
        ListToBST listToBST = new ListToBST();
        ListNode resNode = listToBST.getPreMiddle(head);
        System.out.println(resNode.val);
    }

}
