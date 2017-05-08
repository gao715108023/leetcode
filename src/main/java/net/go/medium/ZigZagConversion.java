package net.go.medium;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR" Write the code
 * that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should return
 * "PAHNAPLSIIGYIR".
 *
 * @author gaochuanjun
 * @since 2017/3/27
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String convert = zigZagConversion.convert(s, numRows);
        System.out.println(convert);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[][] chars = new char[numRows][s.length()];
        int m = 0;
        int n = 0;
        boolean up = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[m][n] = c;
            if (up) {
                m++;
                if (m == numRows) {
                    up = false;
                    m--;
                    m--;
                    n++;
                }
            } else {

                if (m == 0) {
                    m++;
                    up = true;
                } else {
                    m--;
                    n++;
                    if (m == 0) {
                        up = true;
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char[] aChar : chars) {
            for (char anAChar : aChar) {
                if (anAChar != '\u0000') {
                    stringBuilder.append(anAChar);
                }
            }
        }
        return stringBuilder.toString();
    }
}
