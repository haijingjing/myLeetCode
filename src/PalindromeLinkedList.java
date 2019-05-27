import java.util.LinkedList;

//234 回文链表
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        //step1 拆分两个链表
        ListNode slow = head, fast = head, pre = slow;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        if(fast != null){
            slow = slow.next;
        }

        //step2 前面的链表做反转
        ListNode p = head, cur = head.next, next;
        while (cur != null){
            next = cur.next;
            cur.next = p;
            p = cur;
            cur = next;
        }
        head.next = null;

        //step3 比较两个链表
        while (p != null && slow != null){
            if(p.val != slow.val){
                return false;
            }
            p = p.next;
            slow = slow.next;
        }
        return true;
    }
}
