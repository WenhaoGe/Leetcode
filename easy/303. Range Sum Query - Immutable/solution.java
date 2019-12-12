class NumArray {

    int[] array;
    public NumArray(int[] nums) {
        array = new int[nums.length + 1];
        
        array[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            array[i + 1] = array[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        
        return array[j + 1] - array[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */