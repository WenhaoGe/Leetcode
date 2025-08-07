"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':

        if not head:
            return None

        curr = head

        while curr:
            nxt = curr.next
            copy = Node(curr.val, None, None)
            curr.next = copy
            curr.next.next = nxt
            curr = curr.next.next
        
        curr = head

        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        

        ptr_old_list = head
        ptr_new_list = head.next
        new_head = head.next

        while ptr_old_list:
            ptr_old_list.next = ptr_old_list.next.next
            ptr_new_list.next = ptr_new_list.next.next if ptr_new_list.next else None

            ptr_old_list = ptr_old_list.next
            ptr_new_list = ptr_new_list.next
        
        return new_head

