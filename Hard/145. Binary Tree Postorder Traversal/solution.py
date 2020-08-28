# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        
        if not root:
            return []
        nodes = []
        nodes.append(root)
        answer = []
        while nodes:
            node = nodes.pop()
            answer.append(node.val)
            if node.left:
                nodes.append(node.left)
            if node.right:
                nodes.append(node.right)
        
        l = 0
        r = len(answer) - 1
        while l < r:
            answer[l], answer[r] = answer[r], answer[l]
            l += 1
            r -= 1
        
        return answer
        