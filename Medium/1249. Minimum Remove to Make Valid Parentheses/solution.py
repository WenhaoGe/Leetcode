class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        
        stack = []
        for indice, char in enumerate(s):
            if char == '(':
                stack.append(indice)
            elif char == ')':
                if len(stack) > 0 and s[stack[-1]] == '(':
                    stack.pop()
                else:
                    stack.append(indice)
        
        to_be_removed = set(stack)
        answer: str = ""
        for indice, char in enumerate(s):
            if indice in to_be_removed:
                continue
            answer += s[indice]
        
        return answer