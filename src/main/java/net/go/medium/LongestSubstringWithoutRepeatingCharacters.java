package net.go.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 *
 * @author gaochuanjun
 * @since 2017/3/1
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(lswrc.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lswrc.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lswrc.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lswrc.lengthOfLongestSubstring("a"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                Integer index = map.get(c);
                j = Math.max(j, index + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
