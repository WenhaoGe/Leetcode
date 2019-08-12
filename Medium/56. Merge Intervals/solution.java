class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {};
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] last = null;
        for (int[] cur : intervals) {
            if (last == null || cur[0] > last[1]) {
                list.add(cur);
                last = cur;
            } else if (cur[1] > last[1]) {
                last[1] = cur[1];
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}