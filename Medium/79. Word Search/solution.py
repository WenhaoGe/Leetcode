class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        rows = len(board)
        cols = len(board[0])
        for i in range(rows):
            for j in range(cols):
                if self.dfs(board, word, i, j, 0):
                    return True
        return False
    
    def dfs(self, board: List[List[str]], word: str, x: int, y: int, index: int) -> bool:
        if index == len(word):
            return True
        rows = len(board)
        cols = len(board[0])
        if x >= 0 and x < rows and y >= 0 and y < cols:
            if board[x][y] != word[index]:
                return False
            prev = board[x][y]
            board[x][y] = "*"
            result = self.dfs(board, word, x +1, y, index + 1) or self.dfs(board, word, x - 1, y, index + 1) or self.dfs(board, word, x, y + 1, index + 1) or self.dfs(board, word, x, y - 1, index + 1)
            board[x][y] = prev
            return result
        else:
            return False
        