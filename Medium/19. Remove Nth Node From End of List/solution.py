# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        
        curr = head
        length: int = 0
        while curr:
            length += 1
            curr = curr.next
        
        target = length - n

        dummy = ListNode(-1)
        dummy.next = head
        curr = dummy

        for _ in range(target):
            curr = curr.next
        
        curr.next = curr.next.next
        return dummy.next