//160 找到两个单链表相交的起始节点
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int la = 0, lb = 0;
        while (a != null){
            la ++;
            a = a.next;
        }
        while (b != null){
            lb ++;
            b = b.next;
        }

        while (la > lb){
            la --;
            headA = headA.next;
        }
        while (la < lb){
            lb --;
            headB = headB.next;
        }
        while (headA != null && headB != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        if(headA == null || headB == null) return null;
        else return headA;
    }
}
