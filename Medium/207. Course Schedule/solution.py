class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        matrix = [[0 for i in range(numCourses)] for j in range(numCourses)]
        
        indegree = [0] * numCourses
        
        for i in range(len(prerequisites)):
            ready = prerequisites[i][0]
            pre = prerequisites[i][1]
            
            if matrix[pre][ready] == 0:
                indegree[ready] += 1
            matrix[pre][ready] = 1
        count = 0
        queue = deque()
        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(i)
        
        while queue:
            course = queue.popleft()
            count += 1
            for i in range(numCourses):
                if matrix[course][i] != 0:
                    indegree[i] -= 1
                    if indegree[i] == 0:
                        queue.append(i)
        
        return count == numCourses
                
        
        