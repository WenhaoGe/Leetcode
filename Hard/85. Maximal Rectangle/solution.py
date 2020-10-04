class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        
        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        maxarea = 0
        
        rows = len(matrix)
        cols = len(matrix[0])
        heights = [0] * cols
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == "1":
                    heights[j] += 1
                else:
                    heights[j] = 0
            result = self.largestRectangleArea(heights)
            maxarea = max(maxarea, result)
        return maxarea
                        
    
    
    def largestRectangleArea(self, heights: List[int]) -> int:
        
        if not heights or len(heights) == 0:
            return 0
        lessfromleft = [0] * (len(heights) + 1)
        lessfromright = [0] * (len(heights) + 1)
        lessfromleft[0] = -1
        lessfromright[len(heights) - 1] = len(heights)
        
        for i in range(1, len(heights)):
            p = i - 1
            while p >= 0 and heights[p] >= heights[i]:
                p = lessfromleft[p]
            lessfromleft[i] = p
        
        for i in range(len(heights) - 2, -1, -1):
            p = i + 1
            while p < len(heights) and heights[i] <= heights[p]:
                p = lessfromright[p]
            lessfromright[i] = p
        
        maxarea = 0
        for i in range(len(heights)):
            maxarea = max(maxarea, heights[i] * (lessfromright[i] - lessfromleft[i] - 1))
        
        return maxarea