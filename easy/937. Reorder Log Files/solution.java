class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        for(String log: logs) {
            String[] arr = log.split(" ",2);
            if(Character.isDigit(arr[1].charAt(0))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }
        Collections.sort(letters, new Comparator<String>() {
           public int compare(String s1, String s2) {
               String[] arr1 = s1.split(" ",2);
               String[] arr2 = s2.split(" ",2);
               int cmp = arr1[1].compareTo(arr2[1]);
               if(cmp != 0) {return cmp;}
               return arr1[0].compareTo(arr2[0]);
           } 
        });
        String[] ans = new String[logs.length];
        for(int i=0;i<logs.length;i++) {
            if(i<letters.size()) {
                ans[i] = letters.get(i);
            } else {
                ans[i] = digits.get(i - letters.size());
            }
        }
        return ans;
    }
}