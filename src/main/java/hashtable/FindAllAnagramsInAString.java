package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    /**
     * 维护变量count，大小为字符串p的长度。
     * 1.窗口的大小从0开始，增长至p.length。窗口在字符串s中从位置0开始滑动；
     * 2.将p中的所有字符写入到哈希map中，字符---字符数。字符数有3种状态。大于0，表示对应字符仍然有剩余数量可以用来匹配。等于0，表示对应字符刚好匹配完成。小于0，表示字符已过量匹配。
     * 3.在窗口增长为p.length的过程中，s中的字符如果在map中存在，且该字符数仍有剩余，则count--,map中的字符数减1
     * 4.如果窗口的长度为p.length+1，left需要左移，且如果s.charAt(left)在map中，且字符数未超用，则count++，
     * 5.依次遍历，直到字符串的长度。
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int pLen = p.length();
        for (char c :
                p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, count = pLen;
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (map.containsKey(cur)&&map.get(cur)>0) {
                count--;
            }
            if(map.containsKey(cur))
                map.put(cur, map.get(cur) - 1);
            right++;
            if (count == 0) result.add(left);
            if (right - left == pLen) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)&&map.get(leftChar)>=0) {
                    count++;
                }
                if(map.containsKey(leftChar))
                    map.put(leftChar, map.get(leftChar) + 1);

                left++;
            }
        }
        return result;
    }
}
