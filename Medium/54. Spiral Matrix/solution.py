class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        
        answer = []
        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
            return []
        rows = len(matrix)
        cols = len(matrix[0])
        
        rowbegin = 0
        rowend = rows - 1
        colbegin = 0
        colend = cols - 1
        while rowbegin <= rowend and colbegin <= colend:
            # move right
            for i in range(colbegin, colend + 1):
                answer.append(matrix[rowbegin][i])
            rowbegin += 1
            
            # move down
            for j in range(rowbegin, rowend + 1):
                answer.append(matrix[j][colend])
            colend -= 1
            
            # move left
            if rowbegin <= rowend:
                for i in range(colend, colbegin - 1, -1):
                    answer.append(matrix[rowend][i])
            rowend -= 1
            # move up
            if colbegin <= colend:
                for i in range(rowend, rowbegin - 1, -1):
                    answer.append(matrix[i][colbegin])
            colbegin += 1
        
        return answer
        