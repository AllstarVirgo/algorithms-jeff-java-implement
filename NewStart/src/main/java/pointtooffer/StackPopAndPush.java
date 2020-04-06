package pointtooffer;

import java.util.Stack;

public class StackPopAndPush {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer>stack = new Stack<>();
        for (int i = 0,j=0; i < pushA.length; ) {
            stack.push(pushA[i++]);
            while(j<popA.length && popA[j] == stack.peek()){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

}
