from typing import List

class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        
        left: int = 0
        answer: int = 0
        count: int = 0
        for right in range(len(nums)):
            if nums[right] == 0:
                count += 1
            
            while count > 1:
                if nums[left] == 0:
                    count -= 1
                left += 1
            
            answer = max(answer, right - left + 1)
        
        return answer
    