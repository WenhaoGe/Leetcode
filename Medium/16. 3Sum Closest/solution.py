class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        
        if not nums or len(nums) == 0:
            return 0
        
        nums = sorted(nums)
        answer = nums[0] + nums[1] + nums[-1]
        for i in range(len(nums) - 2):
            
            start = i + 1
            end = len(nums) - 1
            while start < end:
                total = nums[i] + nums[start] + nums[end]
                if total > target:
                    end -= 1
                else:
                    start += 1
                
                if abs(answer - target) > abs(total - target):
                    answer = total
        
        return answer
                    
        