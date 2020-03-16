package nowcoder;

import linkedList.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        return merge(l1, l2);
    }


    public ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode cur = new ListNode(-1), head = cur;
        while (a != null || b != null) {
            if (a == null) {
                cur.next = b;
                break;
            } else if (b == null) {
                cur.next = a;
                break;
            } else if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        return head.next;
    }
}
