class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] myList = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=(i+1);j<nums.length;j++)
                if(nums[j] == target-nums[i]){
                    myList[0] =i;
                    myList[1] =j;
                    
                }
                    
        }
        return myList;
    }
}