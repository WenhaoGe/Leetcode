class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 0;
        int len = beginWord.length();
        while (!q.isEmpty()) {
            step++;
            for (int s = q.size(); s > 0; s--) {
                String word = q.poll();
                char[] arr = word.toCharArray();
                for (int i = 0; i < len; i++) {
                    char c = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (c == ch) {
                            continue;
                        }
                        arr[i] = ch;
                        String newOne = new String(arr);
                        if (newOne.equals(endWord)) {
                            return step + 1;
                        }
                        if (!set.contains(newOne)) {
                            continue;
                        }
                        set.remove(newOne);
                        q.offer(newOne);
                    }
                    arr[i] = c;
                }
            }
        }
        return 0;
    }
}