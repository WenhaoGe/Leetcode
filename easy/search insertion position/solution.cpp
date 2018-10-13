class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        
        int index = -1;
        int len = nums.size();
        int max = nums[len-1];
        for(int i=0;i<len;i++){
            if(nums[i] == target){
                index = i;
                break;
            }
        }
        
        if(index == -1){
            for(int j=0;j<len;j++){
                if(max < target){
                    index = len;
                    break;
                }
                else if(nums[j] > target){
                    index = j;
                    break;
                }
            }
        }
        return index;
    }
};