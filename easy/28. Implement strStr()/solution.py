class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        if not needle in haystack:
            return -1
        
        return haystack.index(needle)