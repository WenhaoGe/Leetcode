class Solution {
    boolean[] cols, dia1, dia2;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        cols = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        List<Integer> list = new ArrayList<>();
        putQueen(n, 0, ans, list);
        return ans;
    }

    private void putQueen(int n, int index, List<List<String>> ans, List<Integer> list) {
        if (index == n) {
            ans.add(generateBoard(n, list));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 尝试将第index行的皇后放在第i列
            if (!cols[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                list.add(i);
                cols[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, ans, list);
                cols[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                list.remove(list.size() - 1);
            }
        }
        return;
    }

    private List<String> generateBoard(int n, List<Integer> list) {
        List<String> board = new ArrayList<>();
        assert (list.size() == n);
        // 总共n行，为每一行都declare an array.
        for (int i = 0; i < n; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[list.get(i)] = 'Q';
            board.add(new String(arr));
        }
        return board;
    }
}