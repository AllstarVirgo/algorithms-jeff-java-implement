package leetcode;

import linkedList.ListNode;

public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        long sum = 0;
        long times = 1;
        while(l1!=null){
            sum = sum + l1.val*times;
            times = times * 10;
            l1 = l1.next;
        }

        times = 1;
        while(l2!=null){
            sum = sum + l2.val*times;
            times = times * 10;
            l2 = l2.next;
        }

        if(sum == 0)return new ListNode(0);
        ListNode cur = head;
        while(sum!=0){
            cur.next = new ListNode((int) (sum%10));
            sum = sum/10;
            cur = cur.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(listNode,listNode5);
    }
}
