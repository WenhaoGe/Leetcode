/**
 * TC: O(n)
 * SC: O(1)
 */

class Solution {
    public int videoStitching(int[][] clips, int T) {
        
        Arrays.sort(clips, new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               
               if (a[0] == b[0]) {
                   return a[1] - b[1];
               }
               return a[0] - b[0];
           } 
        });
        int[][] dp = new int[T + 1][T + 1];
        for (int i = 0; i < dp.length; i++) {
          for (int j = 0; j < dp[0].length; j++) {
              dp[i][j] = 101;
          }
        }
        for (int[] clip: clips) {
            int s = clip[0];
            int e = clip[1];
            for (int l = 1; l <= T; l++) {
                for (int i = 0; i <= T - l; i++) {
                    int j = i + l;
                    if (s > j || e < i) {
                        continue;
                    } 
                    if (s <= i && e >= j) {
                        dp[i][j] = 1;
                    } else if (e >= j) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][s] + 1);
                    } else if (s <= i) {
                        dp[i][j] = Math.min(dp[i][j], dp[e][j] + 1);
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i][s] + 1 + dp[e][j]);
                    }
                }
            }
        }
        return dp[0][T] == 101 ? -1 : dp[0][T]; 
    }
}