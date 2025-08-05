class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:

        queue = collections.deque()

        for lst in nestedList:
            queue.append(lst)
        
        depth: int = 1
        answer: int = 0
        while len(queue) > 0:
            size = len(queue)
            for _ in range(size):
                lst = queue.popleft()
                if lst.isInteger():
                    answer += lst.getInteger() * depth
                else:
                    for element in lst.getList():
                        queue.append(element)
            depth += 1
        
        return answer