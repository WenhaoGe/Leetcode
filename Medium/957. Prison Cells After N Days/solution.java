/**
 * Use a HashSet to keep track of different states of the cells. Once found a
 * state already in the hashset, which means there is a cycle exist. record how
 * many rounds in each cycle and break the loop.
 * 
 * loop through the
 */

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0) {
            return cells;
        }
        boolean hasCycle = false;
        Set<String> set = new HashSet<>();
        int cycle = 0;
        for (int i = 0; i < N; i++) {
            int[] next = nextDay(cells);
            String s = Arrays.toString(next);
            if (!set.contains(s)) {
                set.add(s);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }
        N = N % cycle;
        for (int i = 0; i < N; i++) {
            cells = nextDay(cells);
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] ans = new int[cells.length];
        for (int i = 1; i < 7; i++) {
            ans[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return ans;
    }
}