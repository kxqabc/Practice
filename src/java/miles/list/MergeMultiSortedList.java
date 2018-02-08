package miles.list;

import java.util.ArrayList;

public class MergeMultiSortedList {

    private ListNode head = null;

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.isEmpty())
            return null;
        if (lists.size() == 1)
            return lists.get(0);
        for (int i=0;i<lists.size()-1;i=i+2){
            mergeTwoLists(lists.get(i),lists.get(i+1));
        }
        return null;
    }

    public ListNode mergeTwoLists(ListNode listNode1,ListNode listNode2){
        if (listNode1==null || listNode2==null)
            return listNode1==null?listNode2:listNode1;
        ListNode resultList = listNode1.val>listNode2.val?listNode2:listNode1;  //p1指向头节点较小的链表
        ListNode p1 = resultList;
        ListNode p2 = p1==listNode1?listNode2:listNode1;

        ListNode p2Old;
        while (p1!=null && p1.next!=null && p2!=null){
            if (p1.next.val>p2.val){
                //将p2节点插入p1后面
                p2Old = p2;
                p2 = p2.next;
                p2Old.next = p1.next;
                p1.next = p2Old;
                p1 = p1.next;
            }else
                p1 = p1.next;
        }
        if (p2 != null)
            p1.next = p2;

        return resultList;
    }

    public static void main(String[] args) {
        int[] array1 = {1,2};
        int[] array2 = {1};
        ListNode list1 = ListNode.build(array1);
        ListNode list2 = ListNode.build(array2);
        MergeMultiSortedList mergeMultiSortedList = new MergeMultiSortedList();
        ListNode rList = mergeMultiSortedList.mergeTwoLists(list1,list2);
        System.out.println("merged list:" + rList.toString());
    }

}
