class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftToRight = new int[len];
        int[] rightToLeft = new int[len];
        int val = 0;
        for (int i = 0; i < len; i++) {
            val = Math.max(val, height[i]);
            leftToRight[i] = val;
        }
        val = 0;
        for (int i = len - 1; i >= 0; i--) {
            val = Math.max(val, height[i]);
            rightToLeft[i] = val;
        }
        int[] diff = new int[len];
        for (int i = 0; i < len; i++) {
            diff[i] = Math.min(leftToRight[i], rightToLeft[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += diff[i] - height[i];
        }
        return ans;
    }
}