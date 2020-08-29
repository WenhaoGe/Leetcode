class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        
        def connecttopreeachnode(node, pre):
            
            if not node:
                return pre
            next = node.next
            node.next = pre
            return connecttopreeachnode(next, node)
        
        return connecttopreeachnode(head, None)