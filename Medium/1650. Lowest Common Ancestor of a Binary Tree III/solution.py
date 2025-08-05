"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""

class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        
        def getDepth(curr) -> int:

            depth: int = 1

            while curr:
                curr = curr.parent
                depth += 1
            
            return depth
        
        depth1, depth2 = map(getDepth, (p, q))

        if depth1 < depth2:
            p, q = q, p
        
        diff = abs(depth1 - depth2)
        for _ in range(diff):
            p = p.parent
        
        while p is not q:
            p = p.parent
            q = q.parent
        
        return p
        