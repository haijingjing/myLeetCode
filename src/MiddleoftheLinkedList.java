//876. 链表的中间
public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
