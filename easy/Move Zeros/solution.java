class Solution {
    public void moveZeroes(int[] nums) {
        int index=0;
        int size = nums.length;
        for(int i=0;i<size;i++){
            if(nums[i]!=0){
                nums[index++]=nums[i];
            }
        }
        for(;index<size;index++){
            nums[index]=0;
        }
    }
}