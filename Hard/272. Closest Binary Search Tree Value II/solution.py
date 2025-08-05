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
        N = len(store)
        indice = self.binarySearch(store, target)
        print("indice: ", indice)
        answer: List[int] = []

        left = indice - 1
        right = indice

        while len(answer) < k and left >= 0 and right < N:
            if abs(store[right] - target) < abs(store[left] - target):
                answer.append(store[right])
                right += 1
            else:
                answer.append(store[left])
                left -= 1
        
        while len(answer) < k and left >= 0:
            answer.append(store[left])
            left -= 1
        
        while len(answer) < k and right < N:
            answer.append(store[right])
            right += 1
        
        return answer

    def binarySearch(self, store: List[int], target: float) -> int:

        left: int = 0
        right: int = len(store) - 1

        while left <= right:
            mid = (left + right) // 2
            if store[mid] == target:
                return mid
            if store[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        
        if left == len(store):
            return right
        
        if right == -1:
            return left
        
        if abs(store[left] - target) < abs(store[right] - target):
            return left
        else:
            return right
                
        
    def traversal(self, root: TreeNode, store: List[int]) -> None:

        if not root:
            return
        
        self.traversal(root.left, store)
        store.append(root.val)
        self.traversal(root.right, store)
        return