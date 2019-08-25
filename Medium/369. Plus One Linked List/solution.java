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