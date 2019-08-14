/**
 * 首先，我们考虑给定一个数字排列，是否有比它更大的排列 （即若排列为逆序就没有更大的排列了）？这是第一步，判断的方法是，
 * 从后往前遍历数组，判断后一位是否比前一位小，一旦遇到不是的， 那么就必定存在比给定排列更大的排列（此时跳出循环，并记下此时循环变量flag，
 * 方便后面使用）；否则，不存在更大的。
 * 
 * 2、若不存在更大的，那把数组逆序一下即可。
 * 
 * 3、若存在，说明要构造一个更大的排列了，在第一步我们记下的循环变量值flag， 即是要进行改变的位置。此时循环检测flag后面的值，
 * 找到最小的比flag位置的值大的值的位置（好绕呦，结合代码看看喽）， 交换这两个值，然后把flag之后的值按升序排列即可。
 */

class Solution {
    public void nextPermutation(int[] nums) {
        boolean found = false;
        int i = 0;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                found = true;
                break;
            }
        }
        if (found) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                    break;
                }
            }
            reverse(nums, i + 1);
        } else {
            Arrays.sort(nums);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}