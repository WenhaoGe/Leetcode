class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int[] ans = { -1, -1 };
        if (nums.length == 0 || nums == null) {
            return ans;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                ans[0] = 0;
                ans[1] = 0;
            }
            return ans;
        }
        if (nums.length == 2) {
            if (nums[0] == target && nums[1] == target) {
                ans[0] = 0;
                ans[1] = 1;
                return ans;
            } else if (nums[0] == target && nums[1] != target) {
                ans[0] = 0;
                ans[1] = 0;
                return ans;
            } else if (nums[0] != target && nums[1] == target) {
                ans[0] = 1;
                ans[1] = 1;
                return ans;
            } else {
                return ans;
            }
        }
        boolean isFirst = true;
        ans[0] = searchfirst(nums, target, isFirst);
        ans[1] = searchfirst(nums, target, !isFirst);
        return ans;
    }

    private int searchfirst(int[] nums, int target, boolean isFirst) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (isFirst) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            return -1;
        } else {
            if (nums[end] == target) {
                return end;
            }
            if (nums[start] == target) {
                return start;
            }
            return -1;
        }
    }
}