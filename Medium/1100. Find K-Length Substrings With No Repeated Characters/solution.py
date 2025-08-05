class Solution:
    def numKLenSubstrNoRepeats(self, s: str, k: int) -> int:

        if k > len(s):
            return 0

        window = collections.defaultdict(int)
        left: int = 0
        count: int = 0
        for right in range(len(s)):
            window[s[right]] += 1

            while window[s[right]] == 2:
                window[s[left]] -= 1
                left += 1
            

            if right - left + 1 == k:
                count += 1
                window[s[left]] -= 1
                left += 1
        
        return count