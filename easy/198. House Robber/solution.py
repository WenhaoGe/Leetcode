class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if not nums or len(nums) == 0:
            return 0
        dp = [0] * (len(nums) + 1)
        dp[0] = 0
        dp[1] = nums[0]
        for i in range(2, len(nums)+1):
            if nums[i - 1] + dp[i - 2] > dp[i - 1]:
                dp[i] = nums[i - 1] + dp[i - 2]
            else:
                dp[i] = dp[i - 1]
        
        answer = 0
        for each in dp:
            if each > answer:
                answer = each
        return answer