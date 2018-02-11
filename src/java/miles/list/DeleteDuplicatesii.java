package miles.list;

/**
 * remove-duplicates-from-sorted-list-ii
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example, Given1->2->3->3->4->4->5, return1->2->5.
 */
public class DeleteDuplicatesii {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next==null)
            return head;
        ListNode cur = head;    //当前指针位置
        ListNode pre = new ListNode(head.val-1);    //当前指针的的前驱节点
        pre.next = head;    //前驱节点初始化指向头节点
        ListNode newPre = pre;      //负责输出的复制指针
        //循环遍历
        while (cur != null && cur.next != null){
            //如果在cur处出现重复，利用while循环找出重复的最后一个节点的位置
            if (cur.val == cur.next.val){
                //找到连续重复的一串节点的最后一个节点
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;    //  前驱节点指向最后一个重复节点的后驱，相当于将这些节点删除
            }else {
                //如果没有重复，前驱节点后移一位
                pre = cur;
            }
            //当前指针后移一位
            cur = cur.next;
        }
        return newPre.next;
    }

    public static void main(String[] args) {
        int[] array = {1,1,2};
        ListNode head = ListNode.build(array);
        DeleteDuplicatesii deleteDuplicates = new DeleteDuplicatesii();
        ListNode resNode = deleteDuplicates.deleteDuplicates(head);
        System.out.println(resNode.toString());
    }
}
