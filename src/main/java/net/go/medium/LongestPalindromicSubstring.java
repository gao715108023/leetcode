package net.go.medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 * length of s is 1000.
 *
 * Example:
 *
 * Input: "babad"
 *
 * Output: "bab"
 *
 * Note: "aba" is also a valid answer. Example:
 *
 * Input: "cbbd"
 *
 * Output: "bb"
 *
 * @author gaochuanjun
 * @since 2017/3/6
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
//        String input = "babad";
//        String output = lps.longestPalindrome(input);
//        System.out.println(output);
//
//        input = "cbbd";
//        output = lps.longestPalindrome(input);
//        System.out.println(output);
//
//        input = "a";
//        output = lps.longestPalindrome(input);
//        System.out.println(output);
//
//        input = "ccc";
//        output = lps.longestPalindrome(input);
//        System.out.println(output);

        String input = "abcda";
        String output = lps.longestPalindrome(input);
        System.out.println(output);
    }

    public String longestPalindrome(String s) {
        if (s == null)
            return null;

        if (s.length() <= 1)
            return s;

        int low = -1;
        int maxLen = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            //奇数回文
            int m = i;
            int n = i;
            while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
                m--;
                n++;
            }
            int len = n - m - 1;
            if (len > maxLen) {
                maxLen = len;
                low = m + 1;
            }

            //偶数回文
            m = i;
            n = i + 1;
            while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
                m--;
                n++;
            }
            len = n - m - 1;
            if (len > maxLen) {
                maxLen = len;
                low = m + 1;
            }
        }

        if (low == -1) {
            return String.valueOf(s.charAt(0));
        }
        return s.substring(low, low + maxLen);
    }
}
