package linkedList;

public class SortList {

    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode prev = null,slow = head,fast = head;
        while (fast!=null&&fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        prev.next = null;
        ListNode left = head;
        ListNode right = mid;
        return merge(sortList(left), sortList(right));
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (right == null) return left;
        if (left == null) return right;
        ListNode resHead = null,cur = null;
        while (left != null || right != null) {
            if (resHead == null) {
                if (left.val < right.val) {
                    resHead = left;
                    cur = resHead;
                    left = left.next;
                } else {
                    resHead = right;
                    cur = resHead;
                    right = right.next;
                }
            } else {
                if (left == null) {
                    cur.next = right;
                    return resHead;
                } else if (right == null) {
                    cur.next = left;
                    return resHead;
                } else if (left.val < right.val) {
                    cur.next = left;
                    cur = cur.next;
                    left = left.next;
                } else {
                    cur.next = right;
                    cur = cur.next;
                    right = right.next;
                }
            }
        }
        return resHead;
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode cur = null;
        for (int i = 4; i > 0; i--) {
            ListNode listNode = new ListNode(i);
            if (i == 4) {
                head = listNode;
                cur = head;
            } else {
                cur.next = listNode;
                cur = cur.next;
            }
        }
        SortList sortList = new SortList();
    }
}
