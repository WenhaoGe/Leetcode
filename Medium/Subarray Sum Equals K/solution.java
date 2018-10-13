class Solution {
    public int subarraySum(int[] nums, int k) {
        int size = nums.length;
        int count=0;
        int[] arr=new int[size+1];
        arr[0]=0;
        
        for(int i=1;i<=size;i++){
            arr[i]=arr[i-1]+nums[i-1];
        }
        for(int i=0;i<size;i++){
            for(int j=i+1;j<=size;j++){
                if(arr[j]-arr[i]==k){
                    count++;
                }
            }
        }
        
        return count;
    }
}