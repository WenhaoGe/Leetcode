class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        
        map = {}
        for i in range(n):
            map[i] = []
        
        for edge in edges:
            p1 = edge[0]
            p2 = edge[1]
            map[p1].append(p2)
            map[p2].append(p1)
        
        def dfs(i):
            
            for each in map[i]:
                if each not in visited:
                    visited.add(each)
                    dfs(each)
        
        visited = set()
        count = 0
        for i in range(n):
            if i not in visited:
                visited.add(i)
                dfs(i)
                count += 1
        return count
                