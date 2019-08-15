/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

/**
 * 用中序遍历 遍历一遍BST
 */
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        Node dummy = new Node(0, null, null);
        if (root.left == null && root.right == null && root != null) {
            dummy.right = root;
            root.left = root;
            root.right = root;
            return dummy.right;
        }

        List<Node> list = new ArrayList<>();
        dfs(root, list);

        Node head = new Node(list.get(0).val, null, null);
        Node headCopy = head;
        dummy.right = head;

        for (int i = 1; i < list.size(); i++) {
            Node tmp = new Node(list.get(i).val, null, null);
            headCopy.right = tmp;
            tmp.left = headCopy;
            headCopy = tmp;
        }
        headCopy.right = head;
        head.left = headCopy;
        return dummy.right;
    }

    private void dfs(Node root, List<Node> list) {
        // do in-order traversal
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
        return;
    }
}