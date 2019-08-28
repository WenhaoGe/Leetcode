/**
 * 找出每个String的每个character的频率，然后更新到arr1里 遍历了每个String以后，
 */

class Solution {
    public List<String> commonChars(String[] A) {
        int[] arr1 = new int[26];
        Arrays.fill(arr1, Integer.MAX_VALUE);
        for (String str : A) {
            int[] array = new int[26];
            for (char c : str.toCharArray()) {
                array[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                arr1[i] = Math.min(arr1[i], array[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            while (arr1[c - 'a'] > 0) {
                ans.add(c + "");
                arr1[c - 'a']--;
            }
        }
        return ans;
    }
}