/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        preorder(list, root);
        return list;
    }
    private void preorder(List<Integer> list, Node root) {
        
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node node: root.children) {
            preorder(list, node);
        }
        
    } 
}