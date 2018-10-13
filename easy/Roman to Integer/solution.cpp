class Solution {
public:
    int romanToInt(string s) {
        int number =0;
        for(int i=0;i<s.size();i++){
            if(i<s.size()-1&& order(s[i])<order(s[i+1])){
                number = number - order(s[i]);}
            else
                number = number + order(s[i]);
            }
         return number;
    }
    
    int order(char c){
        if(c == 'I') return 1;
        else if(c == 'V') return 5;
        else if(c =='X') return 10;
        else if(c == 'L') return 50;
        else if(c =='C') return 100;
        else if(c =='D') return 500;
        else if(c =='M') return 1000;
    }
    
    
};