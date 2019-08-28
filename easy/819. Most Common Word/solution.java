class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] arr = paragraph.trim().toLowerCase().split("\\W+");
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : banned) {
            set.add(s);
        }
        for (String s : arr) {
            if (!set.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        String res = "";
        int max = 0;
        set = map.keySet();
        for (String s : set) {
            if (map.get(s) > max) {
                max = map.get(s);
                res = s;
            }
        }
        return res;
    }
}