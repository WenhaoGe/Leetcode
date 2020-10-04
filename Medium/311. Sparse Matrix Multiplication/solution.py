class Solution:
    def multiply(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        
        def helper(row, col):
            total = 0
            for i in range(colsA):
                total += A[row][i] * B[i][col]
            return total
            
        rows = len(A)
        colsA = len(A[0])
        cols = len(B[0])
        rowsB = len(B)
        answer = [[0 for i in range(cols)] for j in range(rows)]
        
        for i in range(rows):
            for j in range(cols):
                result = helper(i, j)
                answer[i][j] = result
        return answer