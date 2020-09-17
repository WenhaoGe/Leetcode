class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        
        if not nums or len(nums) == 0:
            return 0
        dp = [1] * len(nums)
        
        answer = 0
        maxlength = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                maxlength += 1
            else:
                answer = max(answer, maxlength)
                maxlength = 1
        
        return max(answer, maxlength)
        