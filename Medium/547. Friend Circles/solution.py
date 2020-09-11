class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        
        def dfs(person):
            M[person][person] = 0
            for i in range(rows):
                if M[i][i] != 0 and M[person][i] == 1:
                    dfs(i)
        rows = len(M)
        count = 0
        for i in range(rows):
            if M[i][i] != 0:
                dfs(i)
                count += 1
        
        return count