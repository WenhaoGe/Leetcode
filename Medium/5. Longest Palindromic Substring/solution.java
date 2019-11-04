// in order to decide if a string is a palindrome
// s.charAt(i) == s.charAt(j) && isPalindrome(i+1, j -1) || j - i <= 2

/**
 * Q5: // mistake 1: do not check the corner case // solution: declare two int
 * arrays. Pass them by reference instead of by value. assume odd length and
 * even length of the input string. choose a point and extend to its both sides.
 * Once the invalid match is found, move two pointers back to their previous
 * positions. Check to see if the length of the current palondrome is the
 * longest, if it is, then replace the values in maxStart and maxEnd with the
 * new values.
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        int[] start = { 0 };
        int[] end = { 0 };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i, sb, start, end);
            extend(s, i, i + 1, sb, start, end);
        }
        for (int i = start[0]; i <= end[0]; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();

    }

    private void extend(String s, int i, int j, StringBuilder sb, int[] start, int[] end) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        i++;
        j--;
        if (j - i > end[0] - start[0]) {
            end[0] = j;
            start[0] = i;
        }
        return;
    }
}