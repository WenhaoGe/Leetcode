class Solution {

    int[] data;
    public Solution(int[] nums) {
        int len = nums.length;
        data = new int[len];
        int index = 0;
        while (index < len) {
            data[index] = nums[index];
            index++;
        } 
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        
        return data;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        int[] copy = new int[data.length];
        int index = 0;
        while (index < data.length) {
            copy[index] = data[index];
            index++;
        }
       
        
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            int r = rand.nextInt(data.length);
            int tmp = copy[r];
            copy[r] = copy[i];
            copy[i] = tmp;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */