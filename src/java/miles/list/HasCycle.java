package miles.list;

/**
 * linked-list-cycle
 * Given a linked list, determine if it has a cycle in it.
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head,fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;  //fast每次走两格
            slow = slow.next;       //slow每次走一格
            //快指针与慢指针指向同一个节点，则说明链表存在环形
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ListNode head = ListNode.build(array);
        HasCycle hasCycle = new HasCycle();
        boolean result = hasCycle.hasCycle(head);
        System.out.println("result:"+result);
    }
}
