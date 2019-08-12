class Solution {
    // TC: O(c); SC: O(1) c means the number of words in the array
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i - 1], words[i], map)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String word1, String word2, Map<Character, Integer> map) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (map.get(word1.charAt(i)) > map.get(word2.charAt(i))) {
                    return false;
                }
                return true;
            }
        }
        if (word1.length() > word2.length()) {
            return false;
        }
        return true;
    }
}