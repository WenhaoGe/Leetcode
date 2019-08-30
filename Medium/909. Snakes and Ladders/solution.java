class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while (!q.isEmpty()) {
            int s = q.poll();
            if (s == N * N) {
                return map.get(s);
            }
            for (int s2 = s + 1; s2 <= Math.min(N * N, s + 6); s2++) {
                int rc = get(s2, N);
                int r = rc / N, c = rc % N;
                int s2Final = 0;
                if (board[r][c] == -1) {
                    s2Final = s2;
                } else {
                    s2Final = board[r][c];
                }
                if (!map.containsKey(s2Final)) {
                    map.put(s2Final, map.get(s) + 1);
                    q.offer(s2Final);
                }
            }
        }
        return -1;
    }

    private int get(int s, int N) {
        // Given a square num s, return board coordinates (r, c) as r*N + c
        int quot = (s - 1) / N;
        int rem = (s - 1) % N;
        int row = N - 1 - quot;
        int col = row % 2 != N % 2 ? rem : N - 1 - rem;
        return row * N + col;
    }
}