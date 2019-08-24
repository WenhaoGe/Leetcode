/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        int size = 0;
        ListNode copy = head;
        while (copy != null) {
            copy = copy.next;
            size++;
        }
        copy = head;
        if (n == 1) {
            while (copy.next.next != null) {
                copy = copy.next;
            }
            copy.next = copy.next.next;
        } else {
            ListNode newhead = head;
            int i = 0;
            while (i < size - n) {
                newhead = newhead.next;
                i++;
            }
            newhead.val = newhead.next.val;
            newhead.next = newhead.next.next;
        }

        return head;
    }
}