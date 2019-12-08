/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        
        Map<Integer, Integer> map = new HashMap<>();
        traversal(map, root);
        List<Integer> ans = new ArrayList<>();
        int freq = 0;
        for (int key: map.keySet()) {
            if (map.get(key) > freq) {
                freq = map.get(key);
            }
        }
        for (int key: map.keySet()) {
            if (map.get(key) == freq) {
                ans.add(key);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
    private void traversal(Map<Integer, Integer> map, TreeNode root) {
        
        if (root == null) 
            return;
        
        traversal(map, root.left);
        map.putIfAbsent(root.val, 0);
        int freq = map.get(root.val);
        map.put(root.val, freq + 1);
        traversal(map, root.right);
        
    }
}