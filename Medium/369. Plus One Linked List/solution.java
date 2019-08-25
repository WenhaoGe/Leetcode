/**
 * At first, find the last digit that is not 9, then increment this digit. Then
 * set all the values after this digit to be 0. Check to see whether the dummy
 * code equals 1, if it is
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNotNine = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != 9) {
                lastNotNine = cur;
            }
            cur = cur.next;
        }
        lastNotNine.val++;
        cur = lastNotNine.next;
        while (cur != null) {
            cur.val = 0;
            cur = cur.next;
        }
        if (dummy.val == 1) {
            return dummy;
        } else {
            return dummy.next;
        }
    }
}