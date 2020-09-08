class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        
        frequency = {}
        for num in nums:
            frequency[num] = frequency.get(num, 0) + 1
        
        answer = []
        for k, v in frequency.items():
            if v == 2:
                answer.append(k)
        
        return answer
        