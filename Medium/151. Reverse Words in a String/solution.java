class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            sb.append(" ");
            sb.append(s.substring(j + 1, i + 1));
            i = j - 1;
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}