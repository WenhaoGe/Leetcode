class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        
        queue = deque()
        
    
        colors = [0 for i in range(len(graph))]
        
        for i in range(len(graph)):
            if colors[i] != 0:
                continue
            queue.append(i)
            colors[i] = 1
            while queue:
                size = len(queue)
                for i in range(size):
                    node = queue.popleft()
                    currentcolor = colors[node]
                    for neighbor in graph[node]:

                        if colors[neighbor] == 0:
                            colors[neighbor] = -currentcolor
                            queue.append(neighbor)
                        else:
                            if colors[neighbor] == currentcolor:
                                return False
                    
        return True
        