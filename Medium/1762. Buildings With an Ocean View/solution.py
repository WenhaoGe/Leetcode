class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:

        answer: List[int] = []
        N = len(heights)
        answer.append(N - 1)
        stack = [N - 1]
        for indice in range(N - 2, -1, -1):
            height = heights[indice]
            can_see = False
            while len(stack) > 0 and height > heights[stack[-1]]:
                can_see = True
                stack.pop()
            
            if len(stack) == 0:
                answer.append(indice)
            stack.append(indice)
        
        answer.reverse()
        return answer