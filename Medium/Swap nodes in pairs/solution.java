class Solution {
    public ListNode swapPairs(ListNode head) {
                ListNode first = head;
        ListNode second = null;
        if(first != null){
            second = head.next;
        }
        
        while(second != null){
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
            
            first = second.next;
            second = null;
            if(first != null){
                second = first.next;
            }
        }
        
        return head;

    }
}