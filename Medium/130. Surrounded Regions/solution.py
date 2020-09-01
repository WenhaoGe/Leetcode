class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        if not board or len(board) == 0 or len(board[0]) == 0:
            return
        
        rows = len(board)
        cols = len(board[0])
        for i in range(rows):
            if board[i][0] == "O":
                self.dfs(board, i, 0)
        for i in range(rows):
            if board[i][cols - 1] == 'O':
                self.dfs(board, i, cols - 1)
        for i in range(cols):
            if board[0][i] == 'O':
                self.dfs(board, 0, i)
        for i in range(cols):
            if board[rows - 1][i] == 'O':
                self.dfs(board, rows - 1, i)
        
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == "*":
                    board[i][j] = "O"
                elif board[i][j] == "O":
                    board[i][j] = "X"
        return
    
    def dfs(self, board: List[List[str]], x: int, y: int) -> None:
        
        board[x][y] = "*"
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        rows = len(board)
        cols = len(board[0])
        
        for dir in dirs:
            newx = x + dir[0]
            newy = y + dir[1]
            if newx >= 0 and newx < rows and newy >= 0 and newy < cols:
                if board[newx][newy] == 'O':
                    self.dfs(board, newx, newy)
                