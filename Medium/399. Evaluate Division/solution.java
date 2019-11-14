class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();

        buildGraph(map, equations, values);

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (!map.containsKey(x) || !map.containsKey(y)) {
                ans[i] = -1.0;
            } else {
                ans[i] = divide(x, y, map, new HashSet<String>());
            }
        }
        return ans;
    }

    private void buildGraph(Map<String, Map<String, Double>> map, List<List<String>> equations, double[] values) {
        int index = 0;
        for (List<String> list : equations) {
            String x = list.get(0);
            String y = list.get(1);
            double quotient = values[index++];
            map.putIfAbsent(x, new HashMap<>());
            map.putIfAbsent(y, new HashMap<>());
            map.get(x).put(y, quotient);
            map.get(y).put(x, 1.0 / quotient);
            map.get(x).put(x, 1.0);
            map.get(y).put(y, 1.0);
        }
    }

    private double divide(String x, String y, Map<String, Map<String, Double>> map, HashSet<String> visited) {
        if (x.equals(y)) {
            return 1.0;
        }
        visited.add(x);
        for (String key : map.get(x).keySet()) {
            if (visited.contains(key)) {
                continue;
            }
            visited.add(key);
            double res = divide(key, y, map, visited);
            if (res > 0) { // 大于0 表示这条路径是有的
                return res * map.get(x).get(key);
            }
        }
        return -1.0;

    }
}