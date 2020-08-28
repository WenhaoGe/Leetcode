# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        
        def dfs(root, currentsum):
            
            if not root:
                return 0
            currentsum = currentsum * 10 + root.val
            if not root.left and not root.right:
                return currentsum
            left = dfs(root.left, currentsum)
            right = dfs(root.right, currentsum)
            return left + right
        
        return dfs(root, 0)