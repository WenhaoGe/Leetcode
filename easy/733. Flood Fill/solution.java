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

/**
 * Solution 2
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int color = image[sr][sc];
        if (color != newColor)
            dfs(image, sr, sc, color, newColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1)
                dfs(image, r - 1, c, color, newColor);
            if (c >= 1)
                dfs(image, r, c - 1, color, newColor);
            if (r + 1 < image.length)
                dfs(image, r + 1, c, color, newColor);
            if (c + 1 < image[0].length)
                dfs(image, r, c + 1, color, newColor);
        }
    }
}