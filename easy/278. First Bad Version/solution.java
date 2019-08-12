/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 0, j = n;
        Stack<Integer> stack = new Stack<>();
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (!isBadVersion(mid)) {
                i = mid + 1;
            } else {
                stack.push(mid);
                j = mid - 1;
            }
        }
        return stack.pop();
    }
}