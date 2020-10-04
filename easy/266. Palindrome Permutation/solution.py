class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        
        if not s or len(s) == 0 or len(s) == 1:
            return True
        freq = {}
        for each in s:
            freq[each] = freq.get(each, 0) + 1
        
        evens = 0
        for k, v in freq.items():
            evens += v // 2
        
        if evens == 0:
            return False
        return len(s) - evens * 2 <= 1
                
        