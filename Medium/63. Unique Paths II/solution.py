
# TC: O(n*m); SC: O(m * n)
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        
        if not obstacleGrid or len(obstacleGrid) == 0 or len(obstacleGrid[0]) == 0:
            return 0
        
        if obstacleGrid[0][0] == 1:
            return 0
        rows = len(obstacleGrid)
        cols = len(obstacleGrid[0])
        
        dp = [[0 for i in range(cols)] for j in range(rows)]
        
        i = 0
        isobstacle = False
        for i in range(cols):
            if obstacleGrid[0][i] == 1:
                isobstacle = True
                
            if isobstacle:
                dp[0][i] = 0
            else:
                dp[0][i] = 1
                
        
        print (dp)
        i = 0
        isobstacle = False
        for i in range(rows):
            if obstacleGrid[i][0] == 1:
                isobstacle = True
                
            if isobstacle:
                dp[i][0] = 0
            else:
                dp[i][0] = 1
        
        
        for i in range(1,rows):
            for j in range(1, cols):
                if obstacleGrid[i][j] == 1:
                    dp[i][j] = 0
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        
        return dp[rows - 1][cols - 1]
        
        