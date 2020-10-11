class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if not nums or len(nums) == 0:
            return 0
        maxval = nums[0]
        for num in nums:
            if maxval < num:
                maxval = num
        
        houses = [0 for i in range(maxval + 1)]
        for num in nums:
            houses[num] += num
        
        dp = [0 for i in range(len(houses) + 1)]
        dp[0]
        dp[1] = houses[0]
        
        for i in range(1, len(houses)):
            dp[i + 1] = max(dp[i], houses[i] + dp[i - 1])
        
        return dp[-1]
        
        