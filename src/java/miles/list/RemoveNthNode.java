package miles.list;

/**
 * remove nth node form end of list
 * Given a linked list, remove the n th node from the end of list and return its head.
 * For Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null || n<=0)
            return null;
        ListNode firstBegin = head;     //先出发的指针
        ListNode secondBegin = head;    //后出发的指针，与先出发的指针中间相差n个节点，当先出发的指针走到结尾null时，后出发的指针就会指向被删除的节点的前驱
        for (int i=n;i>0;i--){
            firstBegin = firstBegin.next;
        }
        ListNode pre = null;    //前驱指针，用于删除
        while (firstBegin!=null){
            pre = secondBegin;
            firstBegin = firstBegin.next;
            secondBegin = secondBegin.next;
        }
        //remove the node
        //pre如果指向头节点
        if (pre == null)
            head = head.next;
        else
            pre.next = pre.next.next;

        return head;
    }

    public static void main(String[] args) {
//        int[] array = {1};
//        ListNode head = ListNode.build(array);
        ListNode head = new ListNode(1);
        RemoveNthNode removeNthNode = new RemoveNthNode();
        removeNthNode.removeNthFromEnd(head,1);
    }
}
