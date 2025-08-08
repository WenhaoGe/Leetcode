# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfSubtree(self, root: TreeNode) -> int:
        
        if not root:
            return 0
        
        self.count = 0
        
        if not root.left and not root.right:
            return 1
        
        res = self.postOrderTraversal(root)
        return self.count
        
    
    def postOrderTraversal(self, curr: TreeNode) -> List[int]:

        if not curr:
            return [0, 0]
        
        if not curr.left and not curr.right:
            self.count += 1
            return [curr.val, 1]
        
        left_total, left_count = self.postOrderTraversal(curr.left)
        right_total, right_count = self.postOrderTraversal(curr.right)

        if (left_total + right_total + curr.val) // (left_count + right_count + 1) == curr.val:
            self.count += 1
        
        return [left_total + right_total + curr.val, left_count+right_count+1]