class Solution:
    def reverse(self, x: int) -> int:
        import math
        sign = 1
        if x < 0:
            sign = -1
            
        x = abs(x)
        num = str(x)
        
        answer = sign * int(''.join(reversed(num)))
        if answer > pow(2, 31) - 1 or answer < -1 * pow(2, 31):
            return 0
        return answer
    
        