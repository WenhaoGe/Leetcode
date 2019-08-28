class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] arr = new int[26];
        List<Integer> ans = new ArrayList<>();
        if(S == null || S.length() == 0) {
            return ans;
        }
        int i = 0;
        for(char c: S.toCharArray()) {
            arr[c - 'a'] = i;
            i++;
        }
        int start = 0;
        int last = 0;
        for(i = 0; i< S.length();i++) {
            last = Math.max(last, arr[S.charAt(i) - 'a']);
            if(last == i) {
                ans.add(last - start + 1);
                start = last + 1;
            }
        }
        return ans;
    }
}