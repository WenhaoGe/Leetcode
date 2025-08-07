class Solution:
    def customSortString(self, order: str, s: str) -> str:

        counter = collections.Counter(s)
        answer = []

        for _, char in enumerate(order):
            if not char in counter:
                continue
            
            freq = counter[char]
            answer.extend([char for _ in range(freq)])
            counter[char] = 0
        
        for key, value in counter.items():
            if value == 0:
                continue
            
            answer.extend([key for _ in range(value)])
        
        return "".join(answer)