//148 链表排序
//要求时间复杂度o(nlogn),空间复杂度常量
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        //step1:cut the list to two halves
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        //step2: sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        //step3: merge l1,l2
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return l.next;
    }


}
