class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int j=0;
        int[] result = new int[length];
        if(k>nums.length)
            k = k% nums.length;
        for(int i=0;i<k;i++)
            result[i]= nums[length-k+i];
        for(int i=k;i<length;i++){
             result[i] = nums[j];
            j++;
        }
        System.arraycopy(result,0,nums,0,length);
    }
}