class LRUCache {
    class DLinkedNode {
        int val;
        int key;
        DLinkedNode prev;
        DLinkedNode next;
    }

    public void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    public DLinkedNode popTail() {
        DLinkedNode pre = tail.prev;
        removeNode(pre);
        return pre;
    }

    int size, count;
    Map<Integer, DLinkedNode> map;
    DLinkedNode head, tail;

    public LRUCache(int capacity) {
        size = capacity;
        count = 0;
        map = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;

        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            DLinkedNode node = new DLinkedNode();
            node.key = key;
            node.val = value;
            map.put(key, node);
            addNode(node);
            count++;
            if (count > size) {
                DLinkedNode tail = popTail();
                count--;
                map.remove(tail.key);
            }
        }
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */