class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int stick : sticks) {
            pq.offer(stick);
        }
        int ans = 0;
        while (pq.size() > 1) {
            int val1 = pq.poll();
            int val2 = pq.poll();
            ans += val1 + val2;
            pq.offer(val1 + val2);
        }
        return ans;
    }
}