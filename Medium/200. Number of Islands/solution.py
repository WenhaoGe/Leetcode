class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid or len(grid) == 0 or len(grid[0]) == 0:
            return 0
        
        rows = len(grid)
        cols = len(grid[0])
        count = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == "1":
                    self.dfs(grid, i, j)
                    count += 1
        return count
                    
    
    def dfs(self, grid: List[List[str]], x: int, y: int) -> None:
        
        
        grid[x][y] = "0"
        rows = len(grid)
        cols = len(grid[0])
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        for dir in dirs:
            newx = x + dir[0]
            newy = y + dir[1]
            if newx >= 0 and newx < rows and newy >= 0 and newy < cols:
                if grid[newx][newy] == "1":
                    self.dfs(grid, newx, newy)
        return
        