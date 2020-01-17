package hashtable;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    /**
     * 维护变量count，大小为字符串p的长度。
     * 1.窗口的大小从0开始，增长至p.length。窗口在字符串s中从0开始滑动；
     * 2.将p中的所有字符写入到哈希map中，字符---字符数
     * 3.在窗口增长为p.length的过程中，s中的字符如果在map中存在，则count--,map中的字符数减1
     * 4.如果窗口的长度为p.length+1，left需要左移，且如果s.charAt(left)在map中，则count++，
     * 5.依次遍历，直到字符串的长度。
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] chars = new int[26];
        int pLen = p.length();
        for (char c :
                p.toCharArray()) {
            chars[c-'a']++;
        }
        int left = 0, right = 0, count = pLen;
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (chars[cur-'a']>0) {
                count--;
            }
            chars[cur-'a']--;
            right++;
            if (count == 0) result.add(left);
            if ((right - left) == pLen) {
                char leftChar = s.charAt(left);
                if (chars[leftChar-'a']>=0) {
                    count++;
                }
                chars[leftChar-'a']++;
                left++;
            }
        }
        return result;
    }
}
