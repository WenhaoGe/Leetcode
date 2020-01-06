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

/**
 * 解法2:
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}

/**
 * solution 3
 * TC: O(m + n)
 * SC: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int cols = matrix[0].length;
        return helper(matrix, target, 0, cols - 1);
    }
    private boolean helper(int[][] matrix, int target, int x, int y) {
        
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return false;
        }
        
        boolean res1 = false, res2 = false;
        if (matrix[x][y] == target) {
            return true;
        }
        
        else if (matrix[x][y] > target) {
            res1 = helper(matrix, target, x, y - 1);
        } else {
            res2 = helper(matrix, target, x + 1, y);
        }
        return res1 || res2;
        
    }
}