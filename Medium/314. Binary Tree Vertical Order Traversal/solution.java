/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

 /**
  * BFS, put node, col into queue at the same time
  * Every left child access col - 1 while right child col + 1
  * This maps node into different col buckets
  * Get col boundary min and max on the fly
  * Retrieve result from cols
  */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;
        nodes.offer(root);
        cols.offer(0);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int col = cols.poll();
            if (map.containsKey(col)) {
                map.get(col).add(node.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(col, list);
            }
            if (node.left != null) {
                nodes.offer(node.left);
                cols.offer(col - 1);
                min = Math.min(min, col - 1);
            }
            if (node.right != null) {
                nodes.offer(node.right);
                cols.offer(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            ans.add(new ArrayList<>(map.get(i)));
        }
        return ans;
    }
}