class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for(int i = 0; i<intervals.length;i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int ans = 0;
        int numberOfRooms = 0;
        int i = 0, j = 0;
        while(i < len && j < len) {
            if(starts[i] < ends[j]) {
                numberOfRooms++;
                ans = Math.max(ans, numberOfRooms);
                i++;
            } else if(starts[i] > ends[j]) {
                numberOfRooms--;
                ans = Math.max(ans, numberOfRooms);
                j++;
            } else {
                i++;
                j++;
            }
            
        }
        return ans;
    }
}