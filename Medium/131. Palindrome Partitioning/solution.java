/**
 * TC: O(n * 2^n)
 * For a string with length n, there will be (n - 1) intervals between chars.
For every interval, we can cut it or not cut it, so there will be 2^(n - 1) ways to partition the string.
For every partition way, we need to check if it is palindrome, which is O(n).
So the time complexity is O(n*(2^n))
 */

class Solution {
    
    List<List<String>> ans;
    List<String> list;
    public List<List<String>> partition(String s) {
        
        list = new ArrayList<>();
        ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        backtracking(s, 0);
        return ans;
    }
    private void backtracking(String s, int index) {
        
        if (list.size() > 0 && index >= s.length()) {
            ans.add(new ArrayList<>(list));
        }
        int len = s.length();
        for (int i = index; i < len; i++) {
            
           if (isPalindrome(s, index, i)) {
               if (i == index) {
                   list.add(Character.toString(s.charAt(i)));
               } else {
                   list.add(s.substring(index, i+ 1));
               }
               backtracking(s, i + 1);
               list.remove(list.size() - 1);
           } 
        }
    }
    private boolean isPalindrome(String s, int l, int r) {
        
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}