class Solution {
    public boolean isSubsequence(String s, String t) {

        if (s == null || s.length() == 0) {
            return true;
        }

        int indexS = 0;
        int indexT = 0;

        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
            }
            if (indexS == s.length()) {
                return true;
            }
            indexT++;
        }
        return false;
    }
}