class Solution:
    def decodeString(self, s: str) -> str:
        
        def helper(s, index):
            num = 0
            word = ""
            while index[0] < len(s):
                char = s[index[0]]
                
                if char == '[':
                    index[0] += 1
                    curstring = helper(s, index)
                    while num > 0:
                        word += curstring
                        num -= 1
                elif char == ']':
                    return word
                elif char >= "0" and char <= "9":
                    num = num * 10 + int(char)
                else:
                    word += char
                index[0] += 1
            return word
        return helper(s, [0])
            
        
        