class Solution {
    public String reverseString(String s) {
        StringBuilder input = new StringBuilder();
        input.append(s);
        input.reverse();
        String str;
        str = input.toString();
        return str;
    }
}