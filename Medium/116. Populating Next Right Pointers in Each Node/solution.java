class Solution {
    public Node connect(Node root) {
        
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            
            int size = q.size();
            if (size == 1) {
                Node node = q.poll();
                node.next = null;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            } else {
                
                List<Node> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node node = q.poll();
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                    list.add(node);
                    }
                for (int i = 1; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        list.get(i).next = null;
                    }
                    list.get(i - 1).next = list.get(i);
                }
            }
            
        }
        return root;
    }
}

/**
 * solution 2
 * TC: O(n)
 * SC: O(1)
 */

class Solution {
    public Node connect(Node root) {
        
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}