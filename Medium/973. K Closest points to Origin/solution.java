class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        if (points == null || points.length == 0) {
            return ans;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
            }
        });
        for (int i = 0; i < K; i++) {
            ans[i] = points[i];
        }
        return ans;
    }
}