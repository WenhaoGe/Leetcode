class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int indices = 0;
        int[] ans = new int[rows * cols];
        int total = rows + cols - 1;
        int index = 0;
        while (index < total) {
          int row = 0;
          if (index - row >= cols) {
            row = index - cols + 1;
          }
          List<Integer> list = new ArrayList<>();
          while (row <= index && row < rows) {
            int col = index - row;
            list.add(matrix[row][col]);
            row++;
          }
          if (index % 2 == 0) {
            Collections.reverse(list);
          }
          for (int i: list) {
            ans[indices++] = i;
          }
          index++;
        }
        for (int i: ans) {
          System.out.print(i + "     ");
        }
        return ans;
    }
}