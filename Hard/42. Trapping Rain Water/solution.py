'''
    l[]: precompute the max of height[0 -> i - 1]
    r[]: precompute the max of height [i - > n - 1]
    then iterate through these 2 lists, find the max of left part of current index
    and find the max of right part of current index
    time complexity: O(n)
    space complexity: O(n)
'''
class Solution:
    def trap(self, height: List[int]) -> int:
        
        l = [0] * len(height)
        r = [0] * len(height)
        
        for i in range(len(height)):
            if i == 0:
                l[i] = height[i]
            else:
                l[i] = max(height[i], l[i - 1])
            
        
        for i in range(len(height) - 1, -1, -1):
            if i == len(height) - 1:
                r[i] = height[-1]
            else:
                r[i] = max(r[i + 1], height[i])
        answer = 0
        for i in range(len(height)):
            answer += min(r[i], l[i]) - height[i]
        
        return answer