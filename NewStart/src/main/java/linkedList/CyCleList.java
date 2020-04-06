package linkedList;

public class CyCleList {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)return null;
        ListNode slow = head,fast = head;
        while(slow!=null&&fast!=null){
            if(slow.next==null)
                return null;
            slow = slow.next;
            if(fast.next==null)
                return null;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }

        ListNode start = head;
        while(start!=slow){
            start = start.next;
            slow = slow.next;
        }
        return start;
    }

    public static void main(String[] args) {
        ListNode s = new ListNode(0);
        ListNode cur = s;
        ListNode entry = null;
        for (int i = 1; i < 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
            if(2==i)
                entry = cur;
        }
        cur.next = entry;
        CyCleList cyCleList = new CyCleList();
        cyCleList.detectCycle(s);
    }
}
