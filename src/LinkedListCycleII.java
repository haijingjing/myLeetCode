//142 环形链表2

/**
 * 假设从head到环入口entry步数为x，环路长度为y，相遇时离entry的距离为m
 则fast：x+ay+m，slow：x+by+m  (a > b)
 x+ay+m = 2(x+by+m)
 整理得x+m = (a-2b)y
 以上式子的含义是，相遇时的位置(m)再前进x步，正好是y的整倍数即整圈。
 现在的问题是怎样计数x。
 利用head到entry的长度为x，只要fast从head每次前进一步，slow从相遇位置每次前进一步
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        boolean flag = false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }
        if(!flag) return null;
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
