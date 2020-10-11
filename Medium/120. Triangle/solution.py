class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        colNum = len(triangle)
        rowNum = len(triangle[colNum - 1])
        
        dp = [[0 for i in range(colNum)] for j in range(rowNum)]
        
        i = 0
        for each in triangle[colNum - 1]:
            dp[rowNum - 1][i] = each
            i += 1
        
        m = 0
        for row in range(rowNum - 2, -1, -1):
            for col in range(colNum - 1 - m):
                dp[row][col] = min(dp[row+1][col], dp[row + 1][col + 1]) + triangle[row][col]
            
            m += 1
        print (dp)
        return dp[0][0]
        