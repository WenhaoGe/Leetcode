class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        int ans = -1;
        while (left < right) {
            if (A[left] + A[right] >= K) {
                right--;
            } else {
                if (A[left] + A[right] > ans) {
                    ans = A[left] + A[right];
                }
                left++;
            }
        }
        return ans;
    }
}