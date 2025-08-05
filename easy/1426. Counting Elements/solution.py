class Solution:
    def countElements(self, arr: List[int]) -> int:

        unique = set(arr)

        count: int = 0
        for element in arr:
            if element + 1 in unique:
                count += 1
        
        return count