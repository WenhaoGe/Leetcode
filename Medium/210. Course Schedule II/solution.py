class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        map = {}
        indegree = [0] * numCourses
        for prerequisite in prerequisites:
            ready = prerequisite[0]
            pre = prerequisite[1]
            map[pre] = map.get(pre, []) + [ready]
            indegree[ready] += 1
        
        queue = deque()
        count = 0
        answer = []
        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(i)
                count += 1
                answer.append(i)
        
        while queue:
            course = queue.popleft()
            totake = map.get(course, [])
            if len(totake) > 0:
                
                for i in range(len(totake)):
                    each = totake[i]
                    indegree[each] -= 1
                    if indegree[each] == 0:
                        queue.append(each)
                        answer.append(each)
                        count += 1
        
        if count == numCourses:
            return answer
        return []
            
        