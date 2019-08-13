/**
 * ans array每一行记录的是matrix在这行的cumulative sum. ans = new
 * int[matrix.length][matrix[0].length + 1]; 在确定好row1, col1, row2, col2以后，
 * 每一行的从col1到col2的值就是ans[i][col2 + 1] - ans[i][col1]
 */

class NumMatrix {

    private int[][] ans;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {return;}
        ans = new int[matrix.length][matrix[0].length + 1];
        for(int i = 0; i<matrix.length;i++) {
            for(int j = 1; j<=matrix[0].length;j++) {
                ans[i][j] = ans[i][j - 1] + matrix[i][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i = row1; i<=row2;i++) {
            res += ans[i][col2 + 1] - ans[i][col1];
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */