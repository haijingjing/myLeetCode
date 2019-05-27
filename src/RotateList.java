//61 旋转链表
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        int len = 0;
        for(; fast.next != null; len++){//此时len 是长度
            fast = fast.next;
        }
        for(int i = len - (k % len); i > 0; i--){
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
