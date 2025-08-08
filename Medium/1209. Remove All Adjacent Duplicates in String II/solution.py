class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        
        stack = []

        for _, char in enumerate(s):
            if len(stack) == 0:
                stack.append([char, 1])
                continue
            
            if char == stack[-1][0]:
                stack[-1][1] += 1
                if stack[-1][1] == k:
                    stack.pop()
            else:
                stack.append([char, 1])
        

        answer: List[str] = []
        for pair in stack:
            key, value = pair
            answer.extend([key for _ in range(value)])
        
        return "".join(answer)