class Solution:
    def consecutiveNumbersSum(self, N: int) -> int:
        
        count = 0
        for m in range(1, int(sqrt(2*N)) + 1):
            if (2*N + m - m*m) % (2*m) == 0 and 2*N + m- m*m > 0:
                count += 1
        
        return count
            
        