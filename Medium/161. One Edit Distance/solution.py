class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        
        length: int = min(len(s), len(t))

        for indice in range(length):
            if s[indice] != t[indice]:
                if len(s) == len(t):
                    # the only possibility is to replace the current char in t with a different character to get s
                    return s[indice + 1:] == t[indice + 1:]
                elif len(s) > len(t):
                    return s[indice + 1:] == t[indice:]
                else:
                    return s[indice:] == t[indice + 1:]
        
        return abs(len(s) - len(t)) == 1
    