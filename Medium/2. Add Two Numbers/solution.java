/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode copy = dummy;
        int sum = 0;
        while (cur1 != null || cur2 != null) {

            if (cur1 != null) {
                sum += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                sum += cur2.val;
                cur2 = cur2.next;
            }
            ListNode node = new ListNode(sum % 10);
            copy.next = node;
            copy = copy.next;
            sum = sum / 10;
        }
        if (sum == 1) {
            ListNode node = new ListNode(1);
            copy.next = node;
        }
        return dummy.next;
    }
}