class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int rows = image.length;
        int cols = image[0].length;
        int[][] ans = new int[rows][cols];
        int same = image[sr][sc];
        helper(ans, image, sr, sc, newColor, same);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (ans[i][j] == 0) {
                    ans[i][j] = image[i][j];
                }
            }
        }
        return ans;
    }

    private void helper(int[][] ans, int[][] image, int i, int j, int newColor, int same) {

        int rows = image.length;
        int cols = image[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }
        if (image[i][j] == same) {
            image[i][j] = -1;
            ans[i][j] = newColor;
            helper(ans, image, i + 1, j, newColor, same);
            helper(ans, image, i, j + 1, newColor, same);
            helper(ans, image, i - 1, j, newColor, same);
            helper(ans, image, i, j - 1, newColor, same);
        }
        return;
    }
}