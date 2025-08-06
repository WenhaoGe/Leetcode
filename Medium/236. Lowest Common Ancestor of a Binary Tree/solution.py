# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        stack = [root]

        parents = dict()
        parents[root] = None

        while not p in parents or not q in parents:

            node = stack.pop()

            if node.left:
                stack.append(node.left)
                parents[node.left] = node
            
            if node.right:
                stack.append(node.right)
                parents[node.right] = node
        
        ancestors = set()

        while p:
            ancestors.add(p)
            p = parents.get(p, None)
        
        while not q in ancestors:
            q = parents[q]
        
        return q
