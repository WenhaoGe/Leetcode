class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            int val = stack.pop();
            for (int nei : rooms.get(val)) {
                if (!visited[nei]) {
                    stack.push(nei);
                    visited[nei] = true;
                }
            }
        }
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Solution 2
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int num = rooms.size();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int val = q.poll();
                visited.add(val);
                List<Integer> list = rooms.get(val);
                for (int each : list) {
                    if (!visited.contains(each)) {
                        q.offer(each);
                    }
                }
            }
        }
        return num == visited.size() ? true : false;
    }
}

/**
 * solution 3
 * TC: O(n)
 * SC: O(n)  n is the number of rooms
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int len = rooms.size();
        boolean[] visited = new boolean[len];
        dfs(rooms, visited, 0);
        for (boolean each: visited) {
            if (!each) {
                return false;
            }
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms, boolean[] visited, int index) {
        
        if (!visited[index]) {
            visited[index] = true;
            List<Integer> keys = rooms.get(index);
            for (int key: keys) {
                dfs(rooms, visited, key);
            }
        }
        return;
        
    }
}