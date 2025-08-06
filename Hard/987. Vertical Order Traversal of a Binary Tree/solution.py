# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        records = dict()

        queue = collections.deque()
        answer: List[List[int]] = []
        queue.append((0, 0, root))
        self.minCol = 0
        self.maxCol = 0

        while queue:

            row, col, node = queue.popleft()
            if not col in records:
                records[col] = []
            records[col].append((row, node.val))
            if node.left:
                queue.append((row + 1, col - 1, node.left))
                self.minCol = min(self.minCol, col - 1)
            if node.right:
                queue.append((row + 1, col +1, node.right))
                self.maxCol = max(self.maxCol, col + 1)
            
        for col in range(self.minCol, self.maxCol + 1):
            pairs = records.get(col, [])
            if len(pairs) == 0:
                continue
            pairs.sort()
            answer.append([pair[1] for pair in pairs])
        
        return answer