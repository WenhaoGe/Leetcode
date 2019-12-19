class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }
        int curRow = 0;
        boolean down = false;
        for (char c: s.toCharArray()) {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                down = !down;
            }
            if (down) {
                curRow++;
            } else {
                curRow--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder each: list) {
            sb.append(each);
        }
        return sb.toString();
    }
}