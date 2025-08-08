class Solution:
    def countSubstrings(self, s: str) -> int:
        
        answer: int = 0
        for indice in range(len(s)):
            answer += self.expandPalindrome(s, indice, indice)
            answer += self.expandPalindrome(s, indice, indice + 1)
        
        return answer
    

    def expandPalindrome(self, s: str, left: int, right: int) -> int:

        count: int = 0

        while left >= 0 and right < len(s) and s[left] == s[right]:
            count += 1
            left -= 1
            right += 1
        
        return count