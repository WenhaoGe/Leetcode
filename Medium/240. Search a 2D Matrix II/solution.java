class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int[] each : matrix) {
            if (each[0] <= target) {
                if (each[0] == target) {
                    return true;
                } else if (search(each, target)) {
                    return true;
                }

            }
        }
        return false;
    }

    private static boolean search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (arr[left] == target) {
            return true;
        }
        if (arr[right] == target) {
            return true;
        }
        return false;
    }
}