package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofAPhoneNumber {
    List<String> res = new ArrayList<>();

    Map<Character, char[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        generate(digits.toCharArray(), 0, new char[digits.length()]);
        return res;
    }

    private void generate(char[] digits, int index, char[] charRes) {
        if (index == digits.length) {
            res.add(new String(charRes));
        } else {
            char[] chars = map.get(digits[index]);
            for (int i = 0; i < chars.length; i++) {
                charRes[index] = chars[i];
                generate(digits, ++index, charRes);
                index--;
            }
        }
    }

    public static void main(String[] args) {
        String test = "";
        LetterCombinationsofAPhoneNumber demo = new LetterCombinationsofAPhoneNumber();
        demo.letterCombinations(test);
    }
}
