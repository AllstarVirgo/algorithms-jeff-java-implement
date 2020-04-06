package pointtooffer;

import linkedList.ListNode;

public class RemoveDuplicateListNode {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null||pHead.next==null)return pHead;
        ListNode res = new ListNode(-1);
        res.next = pHead;
        ListNode cur = res,next = res.next;
        while(next!=null){
            boolean hasSame = false;
            while(next.next!=null && next.val == next.next.val){
                next = next.next;
                hasSame = true;
            }
            if(hasSame){
                cur.next = next.next;
            }else{
                cur = next;
                next = next.next;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        RemoveDuplicateListNode rd = new RemoveDuplicateListNode();
        rd.deleteDuplication(listNode1);
    }
}
