class Solution:
    def intToRoman(self, num: int) -> str:
        
        nums = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        numerals = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        
        index = 0
        answer = ""
        while num > 0:
            while num >= nums[index]:
                
                answer += numerals[index]
                num -= nums[index]
            index += 1
        return answer