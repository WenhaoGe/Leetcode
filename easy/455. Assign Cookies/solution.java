/**
 * Time complexity: O(n) 先把最大的cookie分给需求最大的小孩。
 * 
 */

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gindex = g.length - 1;
        int sindex = s.length - 1;
        int res = 0;
        while (gindex >= 0 && sindex >= 0) {
            if (g[gindex] <= s[sindex]) {
                res++;
                gindex--;
                sindex--;
            } else {
                gindex--;
            }
        }
        return res;
    }
}