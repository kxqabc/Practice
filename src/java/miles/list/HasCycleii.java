package miles.list;

/**
 * linked-list-cycle-ii
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 解题思路：
 *      假设：头结点到环形开始结点的结点个数为a，快慢结点从头结点出发，在距离环形起始结点的顺时针个数为b，环形剩下个数为c，也即（b+c）=L，L为环形周长。
 *      因为快慢结点速度为2倍关系，所以可以列出等式：(a+b)/v1 = [a+n(b+c)+b]/v2 = t;
 *      其中 2*v1 = v2;化简等式则：a+b = nL;n为快指针转的圈数;即 a=nL-b。
 *      a=nL-b 意味着两个结点分别从head和快慢指针交汇点同时出发，以相同的速度（每次一步），第一个结点从head走到目标结点时，第二个结点也正好到达目标结点，即这次相遇的结点就是要求的目标结点。
 */
public class HasCycleii {

    ListNode slow,fast;

    /**
     * 寻找链表中环形链表的开始节点（交汇），如果不存在环形，则返回null
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        //判断有无环形，并且通过快慢指针确定两只真相遇位置结点interchange
        boolean hasCycle = hasCycle(head);
        if (hasCycle){      //如果存在环形
            ListNode interchange = slow,headNode = head;    //相遇位置结点和指向头结点的结点
            //两个结点以相同的速度（每次一步）前进，直到下次相遇，下次相遇的点就是目的结点
            while (interchange != headNode){
                interchange = interchange.next;
                headNode = headNode.next;
            }
            return interchange;
        }else
            return null;
    }

    /**
     * 判断链表中是否存在环形
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        slow = head;
        fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;  //fast每次走两格
            slow = slow.next;       //slow每次走一格
            //快指针与慢指针指向同一个节点，则说明链表存在环形
            if (fast == slow)
                return true;
        }
        return false;
    }
}
