# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestKValues(self, root: Optional[TreeNode], target: float, k: int) -> List[int]:
        
        if not root:
            return []

        if not root.left and not root.right:
            return [root.val]

        store= []
        self.traversal(root, store)
        
        left = 0
        right: int = len(store) - k

        """
        If the element at arr[mid] is closer to target than arr[mid + k], there is no chance arr[mid + k] could be in the answer while arr[mid] isn't. Therefore, we can discard arr[mid + k] and every element to the right of it (move the right pointer).

Vice-versa, if the element at arr[mid + k] is closer to target, then we can discard arr[mid] and every element to the left of it (move the left pointer).
        """

        while left < right:
            mid = (left + right) // 2
            if abs(store[mid + k] - target) > abs(store[mid] - target):
                right = mid
            else:
                left = mid + 1
        
        return store[left: left + k]
    
                
        
    def traversal(self, root: TreeNode, store: List[int]) -> None:

        if not root:
            return
        
        self.traversal(root.left, store)
        store.append(root.val)
        self.traversal(root.right, store)
        return
