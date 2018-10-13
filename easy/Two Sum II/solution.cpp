class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        
        int len = numbers.size();
        
        int left = 0;
        int right = len -1;
        
        while(left < right){
            int v = numbers[left] + numbers[right];
            if(v == target){
                
                vector<int> V {left+1, right+1};
                return V;
            }
            else if(v > target)
                right --;
            else if(v < target)
                left++;
                
        }
    }
};