package miles.list;

/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
 * 注意：分割以后保持原来的数据顺序不变。
 */
public class Partition {

    public ListNode partition(ListNode pHead, int x) {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode small = new ListNode(0);   //小于x的新链表
        ListNode notSmall = new ListNode(0);    //不小于x的新链表
        ListNode s = small;     //复制指针
        ListNode ns = notSmall;     //复制指针
        ListNode p = pHead;     //复制指针
        //循环遍历链表，如果val小于x则插入small表尾，否则插入notSmall表尾
        while(p != null){
            if(p.val < x){
                s.next = p;
                s = s.next;
            }else{
                ns.next = p;
                ns = ns.next;
            }
            p = p.next;
        }
        //拼接两个新链表
        s.next = notSmall.next;
        //切断表尾
        ns.next = null;
        return small.next;
    }

}
