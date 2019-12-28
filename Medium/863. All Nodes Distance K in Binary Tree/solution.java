
/**
 * Use hashmap to build undirected graph of all the nodes
 * do BFS to find all the targets
 */

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        
        List<Integer> list = new ArrayList<>();
        if (root == null || target == null) {
            return list;
        }
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        buildMap(root, null, map);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        while (!q.isEmpty()) {
            
            int size = q.size();
            if (K == 0) {
                for (TreeNode each: q) {
                    list.add(each.val);
                }
                return list;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                List<TreeNode> nodes = map.get(node);
                for (TreeNode each: nodes) {
                    if (!visited.contains(each)) {
                        visited.add(each);
                        q.offer(each);
                    }
                }
            }
            K--;
        }
        return list;
    }
    private void buildMap(TreeNode root, TreeNode parent, Map<TreeNode, List<TreeNode>> map) {
        
        if (root == null) {return;}
        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<TreeNode>());
            if (parent != null) {
                map.get(root).add(parent);
                map.get(parent).add(root);
            }
            buildMap(root.left, root, map);
            buildMap(root.right, root, map);
        }
    }
}