class Solution {
public:
    int lengthOfLastWord(string s) {
        int len = 0;
        
        int length = s.size();
        int tail = length -1;
        while(tail >=0 && s[tail] == ' ')
            tail--;
        
        for(int i=tail;i>=0;i--){
            if(s[i] != ' ')
                len++;
            else if(s[i] == ' ')
                break;
        }
        
        return len;
    }
};