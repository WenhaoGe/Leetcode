class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < len && i < 4; i++) {
            String first = s.substring(0, i);
            if (!isValid(first)) {
                continue;
            }
            for (int j = 1; i + j < len && j < 4; j++) {
                String second = s.substring(i, i + j);
                if (!isValid(second)) {
                    continue;
                }
                for (int k = 1; i + j + k < len && k < 4; k++) {
                    String third = s.substring(i + j, i + j + k);
                    String fourth = s.substring(i + j + k);
                    if (!isValid(third) || !isValid(fourth)) {
                        continue;
                    }
                    String address = first + "." + second + "." + third + "." + fourth;
                    ans.add(address);
                }
            }
        }
        return ans;
    }

    private boolean isValid(String s) {
        if (s.length() > 3) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }

}