/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length - 1;
        return dfs(grid, 0, n, 0, n);
    }
    private Node dfs(int[][] grid, int startX, int endX, int startY, int endY) {
        boolean isSame = true;
        int val = grid[startX][startY];
        for(int i = startX; i<=endX;i++) {
            for(int j = startY;j <= endY;j++) {
                if(grid[i][j] != val) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame) {
                break;
            }
        }
        Node res = null;
        if(isSame) {
            boolean newval = true;
            if(val == 1) {
                newval = true;
            } else {
                newval = false;
            }
            res = new Node(newval, true, null, null, null, null);
            
        } else {
            Node topLeft = dfs(grid, startX, (startX + endX - 1)/2, startY, (startY + endY - 1) / 2);
            Node topRight = dfs(grid, startX, (startX + endX - 1)/2, (startY + endY + 1) / 2, endY);
            Node bottomLeft = dfs(grid, (startX + endX + 1)/2, endX, startY, (startY + endY - 1) / 2);
            Node bottomRight = dfs(grid, (startX + endX + 1)/2, endX, (startY + endY + 1) / 2, endY);
            res = new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
        return res;
    }
}