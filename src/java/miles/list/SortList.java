package miles.list;

public class SortList {
    public ListNode sortList(ListNode head) {
        int temp;
        if (head == null)
            return head;
        while (head.next != null){
            if (head.val>head.next.val){
                temp = head.next.val;
                head.next.val = head.val;
                head.val = temp;
            }
            head = head.next;
        }
    }
}
