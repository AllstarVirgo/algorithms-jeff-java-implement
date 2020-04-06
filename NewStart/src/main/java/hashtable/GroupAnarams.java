package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnarams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] hashCodes = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            hashCodes[i] = hashCode(strs[i]);
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < hashCodes.length; i++) {
            int hashCode = hashCodes[i];
            List<String> res = map.getOrDefault(hashCode, new ArrayList<>());
            res.add(strs[i]);
            map.put(hashCode, res);
        }
        return new ArrayList<>(map.values());
    }

    private int hashCode(String s) {
        char[] chars = s.toCharArray();
        int value = 0;
        for (int i = 0; i < chars.length; i++) {
            value &= chars[i];
        }
        return value;
    }

    public static void main(String[] args) {
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new GroupAnarams().groupAnagrams(test);
    }

}
