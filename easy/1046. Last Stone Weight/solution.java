class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() >= 2) {
            int val1 = pq.poll();
            int val2 = pq.poll();
            if (val2 != val1) {
                pq.offer(val1 - val2);
            }
        }
        if (pq.size() == 0) {
            return 0;
        } else {
            return pq.poll();
        }
    }
}