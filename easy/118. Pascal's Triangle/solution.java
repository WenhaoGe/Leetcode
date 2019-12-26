class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ans.add(list);
        if (numRows == 1) {
            return ans;
        }
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        ans.add(list1);
        if (numRows == 2) {
            return ans;
        }
        for (int i = 2; i < numRows; i++) {
            
            List<Integer> prev = ans.get(i - 1);
            List<Integer> vals = new ArrayList<>();
            vals.add(1);
            for (int j = 1; j < prev.size(); j++) {
                vals.add(prev.get(j - 1) + prev.get(j));
            }
            vals.add(1);
            ans.add(vals);
        }
        return ans;
    }
}