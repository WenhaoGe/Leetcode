class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        
        words = s.split(" ")
        if len(pattern) != len(words):
            return False
        
        map1 = {}
        map2 = {}
        for i in range(len(words)):
            char = pattern[i]
            word = words[i]
            if char in map1:
                if map1[char] != word:
                    return False
            else:
                map1[char] = word
        
        for i in range(len(words)):
            char = pattern[i]
            word = words[i]
            if word in map2:
                if map2[word] != char:
                    return False
            else:
                map2[word] = char
        
        return True
        