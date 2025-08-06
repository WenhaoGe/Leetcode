# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.diameter = 0

        def maxDepth(curr):

            if not curr:
                return 0
            
            if not curr.left and not curr.right:
                return 1
            
            left = maxDepth(curr.left)
            right = maxDepth(curr.right)

            self.diameter = max(self.diameter, left + right)

            return 1 + max(left, right)
        
        maxDepth(root)

        return self.diameter