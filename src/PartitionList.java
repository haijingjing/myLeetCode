//86 分隔链表
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy, pre = dummy, cur = head;
        while (start.next != null && start.next.val < x){
            start = start.next;
        }
        if(start.next == null) return head;
        pre = start.next;
        cur = pre.next;
        while (cur != null){
            if(cur.val < x){
                pre.next = cur.next;
                cur.next = start.next;
                start.next = cur;
                start = start.next;
                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    //把原来的链表拆分成两个链表，一个记录所有节点大于等于x的，一个记录所有节点小于x，然后把两个链表拼接起来
    public ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode p1 = node1, p2 = node2;
        p1.next = head;
        p2.next = head;
        while (head != null){
            if(head.val < x){
                p1.next = head;
                p1 = p1.next;
            }else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = node2.next;
        return node1.next;
    }
}
