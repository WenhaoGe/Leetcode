# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:

        odd = ListNode(-1)
        even = ListNode(-1)
        odd_head = odd
        even_head = even

        indice: int = 1

        while head:
            if indice % 2 == 0:
                even.next = head
                even = even.next
            else:
                odd.next = head
                odd = odd.next
            head = head.next
            indice += 1
        
        even.next = None
        odd.next = even_head.next

        return odd_head.next