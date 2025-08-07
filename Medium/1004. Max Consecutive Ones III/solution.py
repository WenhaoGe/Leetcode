class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        
        answer: int = 0

        left: int = 0
        count: int = 0

        for right in range(len(nums)):
            num = nums[right]
            if num == 0:
                count += 1
            
            while count > k:
                if nums[left] == 0:
                    count -= 1
                left += 1
            
            answer = max(answer, right - left + 1)
        
        return answer