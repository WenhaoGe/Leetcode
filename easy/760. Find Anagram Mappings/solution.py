class Solution:
    def anagramMappings(self, nums1: List[int], nums2: List[int]) -> List[int]:

        records = dict()
        for indice, num in enumerate(nums2):
            records[num] = indice
        
        answer = [-1 for _ in range(len(nums1))]
        for indice, num in enumerate(nums1):
            answer[indice] = records[num]
        
        return answer