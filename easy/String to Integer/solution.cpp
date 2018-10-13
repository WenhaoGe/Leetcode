class Solution {
public:
    int myAtoi(string str) {
    
       int size=str.size();
       int i = str.find_first_not_of(' ');
       string str1;

       for(;i<size;i++){
           str1 = str1+str[i];
         }
         size = str1.size();
        long number=0;
        int min = INT_MIN;
        int max = INT_MAX;
        bool isPositive;
         i=0;
        if(isdigit(str1[i])){
            isPositive=true;
        }
        else if(str1[i]=='-'){
            isPositive=false;
            i=1;
        }
        else if(str1[i]=='+'){
            isPositive=true;
            i=1;
        }
        else 
            return 0;
        char c;
        for(;i<size;i++){
            c=str1[i];
            if(isdigit(c) && number<max){
                number = number*10+(c-'0');
            }
            else
                break;
        }
        
        if(!isPositive){number = number *-1;}
        if(number < min)         return min;
        else if(number > max)    return max;
        else                      return (int)number;
    }
};