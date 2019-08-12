class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            int digit1 = 0, digit2 = 0;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            int remain = sum % 2;
            sb.append(remain + "");
            carry = sum / 2;

        }
        if (carry == 1) {
            sb.append(1 + "");
        }
        return sb.reverse().toString();
    }
}