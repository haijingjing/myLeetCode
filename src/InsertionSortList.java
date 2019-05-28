//147 插入排序链表
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre, cur, next;
        cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = null;
            pre = dummy;
            while (pre != null) {
                if (pre.next == null) {
                    pre.next = cur;
                    cur = next;
                    break;
                } else if (pre.next.val > cur.val) {
                    cur.next = pre.next;
                    pre.next = cur;
                    cur = next;
                    break;
                } else {
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }
}
