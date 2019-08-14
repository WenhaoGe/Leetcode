class WordDictionary {

    /** Initialize your data structure here. */

    Map<Integer, List<String>> map;

    public WordDictionary() {

        map = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        int len = word.length();
        if (map.containsKey(len)) {
            map.get(len).add(word);
        } else {
            List<String> list = new ArrayList<>();
            list.add(word);
            map.put(len, list);
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        boolean isFound = false;
        int len = word.length();
        if (map.get(len) == null) {
            return false;
        }
        for (String each : map.get(len)) {
            isFound = true;
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) == '.') {
                    continue;
                }
                if (word.charAt(i) != each.charAt(i)) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */