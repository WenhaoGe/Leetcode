/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /**
  * TC: O(nlgn)
  * SC: O(1)
  */
class Solution {
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // split the whole linked list into two.
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }
    private ListNode merge(ListNode l1, ListNode l2) {

    ListNode dummy = new ListNode(0);
    ListNode copy = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        copy.next = l1;
        l1 = l1.next;
        copy = copy.next;
      } else {
        copy.next = l2;
        l2 = l2.next;
        copy = copy.next;
      }
    }
    if (l1 != null) {
      copy.next = l1;
    }
    if (l2 != null) {
      copy.next = l2;
    }
    return dummy.next;
  }
}