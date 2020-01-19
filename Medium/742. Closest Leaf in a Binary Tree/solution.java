/**
 * TC: O(n)
 * SC: O(n)
 */

class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode target = null;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.val == k) {
                    target = node;
                    break;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) 
                    q.offer(node.right);
            }
        }
        if (target.left == null && target.right == null) {
            return k;
        }
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        dfs(root, null, map);   
        q.clear();
        q.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                List<TreeNode> list = map.get(node);
                for (TreeNode each: list) {
                    if (each.left == null && each.right == null) {
                        return each.val;
                    }
                    if (!visited.contains(each)) {
                        visited.add(each);
                        q.offer(each);
                    }
                }
            }
        }
        return 0;
    }
    private void dfs(TreeNode cur, TreeNode parent, Map<TreeNode, List<TreeNode>> map) {
        
        if (cur == null) {
            return;
        }
        if (!map.containsKey(cur)) {
            map.put(cur, new ArrayList<TreeNode>());
            if (parent != null) {
                map.get(cur).add(parent);
                map.get(parent).add(cur);
            }
        }
        dfs(cur.left, cur, map);
        dfs(cur.right, cur, map);
    }
}