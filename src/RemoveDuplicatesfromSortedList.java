import java.util.HashSet;

//83. 删除排序链表中的重复元素
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        HashSet<Integer> set = new HashSet<>();
        ListNode p = head;
        set.add(head.val);
        while (head.next != null){
            if(set.contains(head.next.val)){
                head.next = head.next.next;
            }else {
                set.add(head.next.val);
                head = head.next;
            }

        }
        return p;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        while (head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }

        }
        return p;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates3(head.next);
        return head.val == head.next.val? head.next:head;
    }
}
