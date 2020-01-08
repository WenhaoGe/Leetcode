/**
 * TC: O(n)
 * SC: O(n)
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> visited = new HashSet<>();
        ListNode copy = head;
        boolean circle = false;
        
        while (copy != null) {
            if (visited.contains(copy)) {
                circle = true;
                break;
            }
            visited.add(copy);
            copy = copy.next;
        }
        if (!circle) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}