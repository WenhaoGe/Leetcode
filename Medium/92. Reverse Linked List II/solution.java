/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(i < m) {
            head = head.next;
            i++;
        }
        ListNode first = head.next;
        ListNode copyfirst = first;
        ListNode second = first.next;
        while(m < n) {
            ListNode next = second.next;
            second.next = first;
            first = second;
            second = next;
            m++;
        }
        head.next = first;
        copyfirst.next = second;
        return dummy.next;
    }
}