package miles.list;

/**
 *  Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given1->2->3->4, you should return the list as2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;    // current pointer
        ListNode pre = new ListNode(0);     //the pointer that before current pointer
        pre.next = head;    //init pre pointer
        ListNode preNode = pre;     //one copy, change, no influence the result: pre
        while (cur !=null && cur.next != null){
            ListNode temp = cur.next;
            cur.next = temp.next;   //cur pointer move one step
            temp.next = cur;
            preNode.next = temp;
            preNode = cur;
            cur = cur.next;     //cur pointer move the other step, total moved two step in one loop
        }
        return pre.next;    //warming: do not to return head!
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        ListNode head = ListNode.build(array);
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode res = swapNodesInPairs.swapPairs(head);
        System.out.printf("res:"+res.toString());
    }
}
