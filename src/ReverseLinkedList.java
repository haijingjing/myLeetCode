public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur!= null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }

}
