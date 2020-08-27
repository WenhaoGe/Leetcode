class Solution:
    def reverseWords(self, s: str) -> str:
        
        words = s.strip().split()
        l = 0
        r = len(words) - 1
        while l < r:
            words[l], words[r] = words[r], words[l]
            l += 1
            r -= 1
        
        
        answer = ""
        for word in words:
            answer += word
            answer += " "
        return answer.strip()