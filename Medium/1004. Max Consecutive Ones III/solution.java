class Solution {
    public int longestOnes(int[] A, int K) {
        int zero = 0, left = 0, right = 0;
        int ans = 0;
        for (; right < A.length; right++) {
            if (A[right] == 0) {
                zero++;
            }
            while (zero > K) {
                if (A[left] == 0) {
                    zero--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}