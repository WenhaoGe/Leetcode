class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        
        /*int count=0;
        set<int> S;
        vector<int> num1;
        if(k<0 || nums.size() <=1)
            return 0;
        else if(k == 0){
             
            return count;
        }
        else{
            
              for(int i=0;i<nums.size();i++){
                    S.insert(nums[i]);
                }
        for(set<int>::iterator i = S.begin(); i != S.end(); ++i){
              num1.push_back(*i);
            } 
        for(int i=0;i<num1.size();i++){
            for(int j=i+1;j<num1.size();j++)
                if(num1[i]-num1[j]==k || num1[i]-num1[j]==-k)
                    count++;
        }
           
        return count;
        }*/
        int len = nums.size();
        if (k<0 || len <= 1){
            return 0;
        }
        int result = 0;  
        sort(nums.begin(),nums.end());
        unordered_set<int> set1;
        unordered_set<int> sameset;
        for (int i = 0; i < len; i++) {  
            if(k!=0){
                if (!set1.count(nums[i]) && set1.count(nums[i] - k))
                    result++;
                set1.insert(nums[i]);
            } 
            else{ 
                if (!sameset.count(nums[i]) && set1.count(nums[i])) {
                    result++; 
                    sameset.insert(nums[i]);
                }  
                set1.insert(nums[i]);
            }
        }  
        return result;  
    }
};