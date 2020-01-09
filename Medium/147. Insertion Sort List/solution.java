
/**
 * TC: O(n*n)
 * SC: O()
 */

class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        insertionSort(list);
        ListNode dummy = new ListNode(0);
        ListNode copy = dummy;
        for (int i: list) {
            copy.next = new ListNode(i);
            copy = copy.next;
        }
        return dummy.next;
    }
    private void insertionSort(List<Integer> list) {
        
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }
}