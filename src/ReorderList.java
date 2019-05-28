//143 重排链表
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode pre,slow,fast;
        slow = fast = pre = head;
        while (fast != null && fast.next !=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseHead;
        if(fast == null){
            pre.next = null;
            reverseHead = this.reverse(slow);
        }else {
            reverseHead = this.reverse(slow.next);
            slow.next = null;
        }
        while (head != null && reverseHead != null){
            ListNode temp = reverseHead.next;
            reverseHead.next = head.next;
            head.next = reverseHead;
            head = reverseHead.next;
            reverseHead = temp;
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode pre, cur, next;
        pre = head;
        cur = head.next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }
}
