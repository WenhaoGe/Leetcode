class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        
        val1 = int(num1)
        val2 = int(num2)
        
        return ''.join(str(val1 * val2))
        