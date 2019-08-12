class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(arr[left])) {
                left++;
            } else if (!Character.isLetterOrDigit(arr[right])) {
                right--;
            } else {
                if (Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right])) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}