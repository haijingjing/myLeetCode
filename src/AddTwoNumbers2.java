public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode s = head;
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
        return s.next;

    }
}
