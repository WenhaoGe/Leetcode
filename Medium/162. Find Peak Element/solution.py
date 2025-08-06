class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        if len(nums) == 0:
            return -1
        
        if len(nums) == 1:
            return 0
        
        if nums[0] > nums[1]:
            return 0
        
        N = len(nums)
        if nums[N-1] > nums[N-2]:
            return N - 1
        
        left: int = 0
        right: int = N - 1

        while left <= right:
            mid = (left + right) // 2
            if nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1]:
                return mid
            
            if nums[mid - 1] > nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
        
        return -1