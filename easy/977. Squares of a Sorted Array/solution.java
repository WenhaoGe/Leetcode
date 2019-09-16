class Solution {
    public int[] sortedSquares(int[] A) {
        int i = 0, j = A.length - 1;
        int[] ans = new int[A.length];
        for (int p = A.length - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                ans[p] = A[i] * A[i];
                i++;
            } else {
                ans[p] = A[j] * A[j];
                j--;
            }
        }
        return ans;
    }
}