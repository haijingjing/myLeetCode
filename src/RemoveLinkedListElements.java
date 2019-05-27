//203 删除链表元素
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null || (head.next == null && head.val == val)) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, p = head;
        while (p != null){
            if(p.val == val){
                pre.next = p.next;
            }else {
                pre = p;
            }
            p = p.next;
        }
        return dummy.next;
    }
}
