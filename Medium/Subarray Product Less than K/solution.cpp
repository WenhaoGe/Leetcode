class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int count=0;
        int left=0;
        int right=0;
        int product=1;
        int size = nums.size();
        for(;right<size;right++){
            product *=nums[right];
            while(right>=left && product>=k){
                product /=nums[left];
                left++;
            }
            count += right>=left? right-left+1:0;
        }
        
        return count;
       
    }
};