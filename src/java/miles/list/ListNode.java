package miles.list;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
    public static ListNode build(int[] array){
        if (array == null || array.length<=0)
            return null;
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i:array){
            current.next = new ListNode(i);
            current = current.next;
        }
        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this==null)
            return null;
        ListNode current = this;
        while (current!=null){
            stringBuilder.append(current.val+",");
            current = current.next;
        }
        String result = stringBuilder.substring(0,stringBuilder.length()-1);
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ListNode head = ListNode.build(array);
        System.out.println(head.toString());

        ListNode current = head;
        System.out.println("head==current?" + (head==current));
        head = head.next;
        System.out.println("head.val="+head.val);
        System.out.println("current.val="+current.val);
        System.out.println("head==current?" + (head==current));

    }
}
