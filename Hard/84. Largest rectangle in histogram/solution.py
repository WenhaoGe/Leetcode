class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        
        if not heights or len(heights) == 0:
            return 0
        
        lessfromleft = [0] * len(heights)
        lessfromright = [0] * len(heights)
        lessfromleft[0] = -1
        lessfromright[len(heights) - 1] = len(heights)
        
        for i in range(1, len(heights)):
            p = i - 1
            while p >= 0 and heights[p] >= heights[i]:
                p = lessfromleft[p]
            lessfromleft[i] = p
        
        for i in range(len(heights) - 2, -1, -1):
            p = i + 1
            while p < len(heights) and heights[p] >= heights[i]:
                p = lessfromright[p]
            lessfromright[i] = p
        
        maxarea = 0
        for i in range(len(heights)):
            maxarea = max(maxarea, heights[i] * (lessfromright[i] - 1 - lessfromleft[i]))
        
        return maxarea