/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode second = head.next;
            head.next = second.next;
            second.next = head;
            prev.next = second;
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }
}