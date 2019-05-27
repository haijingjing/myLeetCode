public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int flag = 0;
        int length1 = 0, length2 = 0;
        ListNode head1 = l1;
        ListNode head2 = l2;
        while (head1!= null){
            length1 ++;
            head1 = head1.next;
        }
        while (head2 != null){
            length2 ++;
            head2 = head2.next;
        }


        if(length1 < length2){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode maxhead = l1;
        ListNode minhead = l2;

        while (maxhead != null){
            if(minhead == null){
                maxhead.val = maxhead.val + 0 + flag;
            }else {
                maxhead.val = maxhead.val + minhead.val + flag;
            }
            if(maxhead.val >= 10){
                flag = 1;
                maxhead.val -= 10;
            }else {
                flag = 0;
            }
            maxhead = maxhead.next;
            if(minhead != null){
                minhead = minhead.next;
            }
        }

        maxhead = l1;
        if(flag == 1){
            while (maxhead.next != null){
                maxhead = maxhead.next;
            }
            ListNode node = new ListNode(1);
            node.next = null;
            maxhead.next = node;
        }
        return l1;

    }
}
