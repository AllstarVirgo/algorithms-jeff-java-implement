package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, n, "", 0, 0);
        return result;
    }

    private void backtrack(List<String> result, int n, String s, int left, int right) {
        if (s.length() == 2 * n) {
            result.add(s);
        } else {
            if (left < n) {
                backtrack(result, n, '(' + s, ++left, right);
            }
            if (right < left) {
                backtrack(result, n, s + ')', left, ++right);
            }
        }
    }


    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(3);
    }
}
