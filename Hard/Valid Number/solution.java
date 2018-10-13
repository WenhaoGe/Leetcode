class Solution {
    public boolean isNumber(String s) {
        String intPattern = "[-+]?[0-9]+";
        String doublePattern = "[-+]?[0-9]+[\\.][0-9]*|[-+]?[0-9]*[\\.][0-9]+";
        String expPattern = "(" + intPattern + "|" + doublePattern + ")[eE]{1}" + intPattern;
        String pattern = "[\\s]*(" + intPattern + "|" + doublePattern + "|" + expPattern + ")[\\s]*";
        return s.matches(pattern);

    }
}