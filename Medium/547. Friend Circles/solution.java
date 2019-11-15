/**
 * DFS in graph
 */

class Solution {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        boolean[] visited = new boolean[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] M, boolean[] visited, int i) {

        visited[i] = true;
        int len = M[i].length;
        for (int j = 0; j < len; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, visited, j);
            }
        }
    }
}