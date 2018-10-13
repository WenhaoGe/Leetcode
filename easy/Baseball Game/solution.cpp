#include<iostream>
#include<numeric>
#include<vector>
using namespace std;

class Solution {
public:
    int calPoints(vector<string>& ops) {
        vector<int> rounds;
        for(int i=0;i<ops.size();i++){
            if(ops[i] == "D")
                rounds.push_back(rounds.back() *2);
            else if(ops[i] == "C")
                rounds.pop_back();
            else if(ops[i] == "+"){
                int size = rounds.size();
                rounds.push_back(rounds[size-1]+rounds[size-2]);
            }
            else
                rounds.push_back(stoi(ops[i]));
        }
       return accumulate(rounds.begin(),rounds.end(),0);
        
    }
};

 