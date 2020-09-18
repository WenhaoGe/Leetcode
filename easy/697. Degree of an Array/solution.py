class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        
        
        first_seen = {}
        count = {}
        degree = 0
        minlengh = 0
        for i in range(len(nums)):
            if nums[i] not in first_seen:
                first_seen[nums[i]] = i
            
            count[nums[i]] = count.get(nums[i], 0) + 1
            if count.get(nums[i]) > degree:
                degree = count.get(nums[i], 0)
                minlength = i - first_seen.get(nums[i]) + 1
            elif count.get(nums[i]) == degree:
                minlength = min(minlength, i - first_seen.get(nums[i], 0) + 1)
        
        return minlength