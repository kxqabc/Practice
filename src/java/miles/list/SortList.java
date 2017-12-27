package miles.list;


public class SortList {

    public ListNode sortList(ListNode head) {
        //当链表为null或者只有一个节点
        if (head==null || head.next==null)
            return head;
        ListNode mid = getMid(head);    //链表的中间节点
        ListNode midNext = mid.next;    //链表的中间节点的下一个节点
        mid.next = null;    //将一个链表从中间断开，拆分为两个链表
        //下面这个比较重要，通过递归，进入最后一个递归时每个链表只有一个节点，然后用mergeList将这两个节点构成一个节点，组成包含两个节点的链表；然后回到上一层递归，将两个排好序的链表合并成一个链表
        return mergeList(sortList(head),sortList(midNext));     //递归，讲两个排好序的链表合并
    }

    /**
     * 得到以head为头结点的链表的中间节点
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head){
        //跳出条件，当链表为null或者只有一个节点
        if (head==null || head.next==null)
            return head;
        //利用快慢指针，快指针每次走两格，慢指针每次走一格，直到快指针不能再走时慢指针的位置就是在链表的中间
        ListNode slow = head;
        ListNode fast = head;
        //当fast还能再走一步（两格），则执行循环
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 将两个有序的链表合并
     * @param head1
     * @param head2
     * @return
     */
    private ListNode mergeList(ListNode head1,ListNode head2){
        ListNode newHead = new ListNode(0);     //合并后的头指针，但是此头部只包含与结果不相关的“0”，其实返回的是它的后一个节点
        ListNode current = newHead;
        while (head1!=null && head2!=null){
            if (head1.val<head2.val){
                current.next = head1;
                head1 = head1.next;
            }else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        //如果一个链表为空，则直接将另一个不为空的链表加载到链表的最后
        current.next = head1==null?head2:head1;
        return newHead.next;
    }

    public static void main(String[] args) {
        int[] array = {1,2,4,3,5};
        ListNode head = ListNode.build(array);
        SortList sortList = new SortList();
        ListNode newHead = sortList.sortList(head);
        System.out.println(newHead.toString());
    }
}
