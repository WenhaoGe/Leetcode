class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        counter = collections.Counter(t)
        required = len(counter)
        window = dict()
        right: int = 0
        left: int = 0
        formed: int = 0
        answer = [len(s) + 1, 0, len(s)]
        while right < len(s):
            char = s[right]

            if not char in window:
                window[char] = 0
            window[char] += 1

            if char in counter and window[char] == counter[char]:
                formed += 1
            
            while left <= right and formed == required:
                if answer[2] - answer[1] > right - left:
                    answer = [right - left + 1, left, right]
                
                char2 = s[left]
                left += 1
                window[char2] -= 1
                if char2 in counter and window[char2] < counter[char2]:
                    formed -= 1
            
            right += 1
        
        if answer[0] == len(s) + 1:
            return ""
        
        left = answer[1]
        right = answer[2]
        return s[left: right + 1]