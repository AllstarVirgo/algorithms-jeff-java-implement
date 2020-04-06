package nowcoder;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack = new Stack<>();
        int result = 0;
        for(int i = 0;i<tokens.length;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                //前面的数操作后面的数
                int after = stack.pop();

                int before = stack.pop();

                switch(tokens[i]){
                    case "+":
                        result = before+after;
                        break;
                    case "-":
                        result = before-after;
                        break;
                    case "*":
                        result = before*after;
                        break;
                    case "/":
                        result = before/after;
                }
                stack.push(result);
            }else
                stack.push(Integer.parseInt(tokens[i]));
        }
        if(!stack.empty())result = stack.pop();
        return result;
    }

}
