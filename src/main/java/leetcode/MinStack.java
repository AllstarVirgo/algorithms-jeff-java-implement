package leetcode;

import java.util.Stack;

/*
链表解法
 */
public class MinStack {

    class Node{
        int val;

        Node next;

        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Node head;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(head ==null){
            head = new Node(x,x);
        }else {
            Node node = new Node(x,Math.min(x,head.min));
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        if(head!=null)
            head = head.next;
    }

    public int top() {
        if(head!=null)
            return head.val;
        return -1;
    }

    public int getMin() {
        if(head!=null)
            return head.min;
        return -1;
    }

    public static void main(String[] args) {
        MinStackUseStack m = new MinStackUseStack();
        m.push(3);
        System.out.println(m.min);
        m.push(4);
        System.out.println(m.min);
        m.push(2);
        System.out.println(m.min);
        m.push(3);
        System.out.println(m.min);
        m.pop();
        System.out.println(m.min);
        m.pop();
        System.out.println(m.min);
        m.pop();
        System.out.println(m.min);
        m.push(0);
        System.out.println(m.min);
    }
}

/**
 * 栈解法
 */
class MinStackUseStack{
    /** initialize your data structure here. */

    int min = Integer.MAX_VALUE;

    Stack<Integer>stack = new Stack<>();
    public MinStackUseStack() {

    }

    public void push(int x) {
        //pop()方法调用时，在stack.pop()等于min的情况下，会pop两次
        //因此当x<min时，也需要插入两次到栈
        if(x<=min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop()==min)min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
