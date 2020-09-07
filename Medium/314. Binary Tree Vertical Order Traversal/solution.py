# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root:
            return []
        queue = deque()
        positions = deque()
        queue.append(root)
        positions.append(0)
        pairs = {}
        while queue:
            size = len(queue)
            
            for _ in range(size):
                node = queue.popleft()
                position = positions.popleft()
                
                if not position in pairs:
                    pairs[position] = []
                
                pairs[position].append(node.val)
                if node.left:
                    queue.append(node.left)
                    positions.append(position - 1)
                if node.right:
                    queue.append(node.right)
                    positions.append(position + 1)
        
        answer = []
        for i in sorted(pairs.keys()):
            answer.append(pairs[i])
        
        return answer