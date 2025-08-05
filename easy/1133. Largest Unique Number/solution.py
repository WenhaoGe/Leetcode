class Solution:
    def largestUniqueNumber(self, nums: List[int]) -> int:

        answer: int = -1
        counter = collections.Counter(nums)
        for key, value in counter.items():
            if value == 1:
                if key > answer:
                    answer = key
        
        return answer