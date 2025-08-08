# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []

        self.helper(root)

    
    def helper(self, root: TreeNode) -> None:

        while root:
            self.stack.append(root)
            root = root.left
        

    def next(self) -> int:

        next_node = self.stack.pop()

        if next_node.right:
            self.helper(next_node.right)
        
        return next_node.val
        

    def hasNext(self) -> bool:
        return len(self.stack) > 0