

/**
 * Queue + BFS
 * TC: O(n)
 * SC: O(n)
 */
class Solution {
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Node> list = new ArrayList<>();
            for (int i= 0; i < size; i++) {
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
        return root;
    }
}