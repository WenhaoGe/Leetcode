class Solution {
    public Node copyRandomList(Node head) {
        Node ans = head;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node newNode = new Node(cur.val);
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node dummy = new Node(0);
        Node dummyCopy = dummy;
        Node copy;
        cur = head;
        while (cur != null) {
            Node next = cur.next.next;
            copy = cur.next;
            dummyCopy.next = copy;
            dummyCopy = copy;
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }
}