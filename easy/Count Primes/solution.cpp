class Solution {
public:
    int countPrimes(int n) {
        
        int count=0;
        for(int i=1;i<n;i++){
            if(isPrime(i))
                count++;
        }
        return count;
        
    }
    
    bool isPrime(int number){

    if(number < 2) return false;
    if(number == 2) return true;
    if(number % 2 == 0) return false;
    for(int i=3; (i*i)<=number; i+=2){
        if(number % i == 0 ) return false;
    }
    return true;

}
};