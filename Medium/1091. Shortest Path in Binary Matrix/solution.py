class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        
        N = len(grid)
        if grid[0][0] == 1 or grid[N - 1][N - 1] == 1:
            return -1


        queue = collections.deque()
        queue.append((0, 0))
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, 1), (1, -1)]

        steps: int = 1

        while queue:
            size = len(queue)
            for _ in range(size):
                row, col = queue.popleft()
                if row == N - 1 and col == N - 1:
                    return steps
                for direction in directions:
                    newrow = row + direction[0]
                    newcol = col + direction[1]
                    if 0 <= newrow < N and 0 <= newcol < N and grid[newrow][newcol] == 0:
                        if newrow == N - 1 and newcol == N - 1:
                            return steps + 1

                        queue.append((newrow, newcol))
                        grid[newrow][newcol] = 1
            steps += 1
        
        return -1