class Solution:
    def validWordSquare(self, words: List[str]) -> bool:
        
        ROWS = len(words)
        COLS = 0
        for word in words:
            COLS = max(COLS, len(word))
        
        matrix = [["" for _ in range(COLS)] for _ in range(ROWS)]
        row = 0
        for word in words:
            for indice in range(len(word)):
                matrix[row][indice] = word[indice]
            row += 1
        
        for row in range(ROWS):
            curr_row = matrix[row]
            curr_col = self.getColumn(matrix, row)
            if curr_row != curr_col:
                return False
        
        return True
    
    def getColumn(self, matrix: List[List[str]], col: int) -> List[int]:

        answer = []
        ROWS = len(matrix)
        for row in range(ROWS):
            answer.append(matrix[row][col])
        
        return answers