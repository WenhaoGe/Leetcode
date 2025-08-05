class Solution:
    def calculate(self, s: str) -> int:

        s = s.strip()
        
        curr_num: int = 0
        operator = '+'
        stack = []

        for indice, char in enumerate(s):
            if char.isdigit():
                curr_num = curr_num * 10 + ord(char) - ord('0')
            
            if char in "+-*/" or indice == len(s) - 1:
                if operator == '+':
                    stack.append(curr_num)
                elif operator == '-':
                    stack.append(-curr_num)
                elif operator == '*':
                    value = stack.pop()
                    stack.append(value * curr_num)
                elif operator == '/':
                    # truncate towards zero
                    prev_value = stack.pop()
                    if prev_value < 0:
                        stack.append(-(-prev_value // curr_num))
                    else:
                        stack.append(prev_value // curr_num)
            
                operator = char
                curr_num = 0
        
        print(stack)
        
        return sum(stack)
