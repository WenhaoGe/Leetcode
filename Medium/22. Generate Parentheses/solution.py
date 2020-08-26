class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        answer = []
        def dfs(combination, open, close):
            
            if len(combination) == 2 * n:
                answer.append(str(combination))
                return
            if open < n:
                dfs(combination + "(", open + 1, close)
            if close < open:
                dfs(combination + ")", open, close + 1)
        
        dfs("", 0, 0)
        return answer