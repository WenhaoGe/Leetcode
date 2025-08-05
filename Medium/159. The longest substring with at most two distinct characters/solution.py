class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        
        left: int = 0
        right: int = 0
        records = dict()
        max_length = 2
        answer: int = 0
        while right < len(s):
            records[s[right]] = right

            if len(records) > max_length:
                min_indice = min(records.values())
                del records[s[min_indice]]
                left = min_indice + 1
            
            answer = max(answer, right - left + 1)
            right += 1
        
        return answer
    