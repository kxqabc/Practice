package miles.list;

/**
 * remove-duplicates-from-sorted-list
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class DeleteDuplicates {
    /**
     * 删除链表(已排序）中重复的结点，每种重复的只能保留一个
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode current = head;
        //如果当前结点与下一个结点数值相等，则删除下一结点
        while (current!=null && current.next!=null){
            //如果和下一节点相等，则删除下一节点，但是当前结点位置不能动，否则在三个及以上连续相等情况下会出现遗漏
            if (current.val == current.next.val)
                current.next = current.next.next;
            else
                current = current.next;
        }
        return head;
    }
}
