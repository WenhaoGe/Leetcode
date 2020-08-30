class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        
        if len(s) != len(t):
            return False
        
        map = {}
        for i in range(len(s)):
            if s[i] in map:
                if map[s[i]] != t[i]:
                    return False
            else:
                map[s[i]] = t[i]
        
        map = {}
        for i in range(len(t)):
            if t[i] in map:
                if map[t[i]] != s[i]:
                    return False
            else:
                map[t[i]] = s[i]
        
        return True
        