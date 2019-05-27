//24 两两交换链表中的节点
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = head, then = head.next, pre = dummy;
        while (start != null && then != null){
            start.next = then.next;
            then.next = start;
            pre.next = then;
            pre = start;
            start = start.next;
            if(start != null){
                then = start.next;
            }
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head.next = swapPairs2(head.next);
        return temp;
    }
}
