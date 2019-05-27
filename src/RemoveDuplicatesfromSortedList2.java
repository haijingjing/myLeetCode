import java.util.HashSet;

//82. 删除排序链表中的重复元素 II
public class RemoveDuplicatesfromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        HashSet<Integer> set = new HashSet<>();
        ListNode p = head;
        while (head.next != null){
            if(head.val == head.next.val && !set.contains(head.val)){
                set.add(head.val);
            }else {
                head = head.next;
            }
        }
        head =  p;
        while (head.next != null){
            if(set.contains(head.next.val)){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        if(set.contains(p.val)){
            p = p.next;
        }
        return p;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0), pre = dummy;
        dummy.next = head;
        while(head!=null){
            if(head.next==null || head.val!= head.next.val){
                pre = head;
                head = head.next;
            }else{
                int val = head.val;
                while(head!=null && head.val==val){
                    head = head.next;
                }
                pre.next = head;
            }
        }
        return dummy.next;
    }
}
