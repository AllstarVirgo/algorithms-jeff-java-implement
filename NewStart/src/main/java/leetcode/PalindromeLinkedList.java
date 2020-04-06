package leetcode;

import linkedList.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode slow = head,fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //fast!=null。说明上一个循环停止的原因是fast.next == null。
        //链表的长度为偶数长，slow因为循环条件停止，没有向前移动
        if(fast!=null)
            slow = slow.next;

        slow = reverse(slow);

        while(head!=null&&slow!=null){
            if(head.val!=slow.val)return false;
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    ListNode reverse(ListNode head){
        if(head==null)return null;
        ListNode newHead = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
}
