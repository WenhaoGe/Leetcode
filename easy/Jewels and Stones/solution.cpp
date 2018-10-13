class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int count=0;
        
        for(int i=0;i<S.size();i++){
            if(check(S[i],J)){count++;}
        }
        return count;
    }
    
    bool check(char c,string J){
        for(int i=0;i<J.size();i++){
            if(J[i]==c){return true;}
        }
        return false;
    }
};