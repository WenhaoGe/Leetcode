class Solution {
    public void reverseWords(char[] s) {
        String str = new String(s);
        String[] words = str.split("\\s+");
        
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String tmp = words[left];
            words[left] = words[right];
            words[right] = tmp;
            left++;
            right--;
        }
        
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            for (char c: words[i].toCharArray()) {
                s[index++] = c;
            }
            if (i != words.length - 1) {
                s[index++] = ' ';
            }
        }
        return;
    }
}

/**
 * solution 2
 */
class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        
        reverse(s, start, s.length - 1);
        return;
    }
    
    private void reverse(char[] s, int left, int right) {
        
        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}