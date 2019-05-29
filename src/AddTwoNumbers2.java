//445 两数之和2
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        l1 = this.reverse(l1);
        l2 = this.reverse(l2);

        ListNode head = new ListNode(0);
        ListNode dummy = head;
        int sum = 0;
        while (l1 != null || l2 != null){
            sum = sum/10;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
        }
        if(sum / 10 == 1){
            head.next = new ListNode(1);
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre, cur, next,dummy;
        dummy = new ListNode(0);
        dummy.next = head;
        pre = head;
        cur = head.next;

        while (cur != null){
            next = cur.next;
            pre.next = next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
