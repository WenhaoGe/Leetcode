class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        
        indice0: int = 0
        indice1: int = 0

        while indice0 < len(word) and indice1 < len(abbr):
            if word[indice0] == abbr[indice1]:
                indice0 += 1
                indice1 += 1
                continue
            
            if abbr[indice1] <= '0' or abbr[indice1] > '9':
                return False
            
            start = indice1
            num = 0
            while indice1 < len(abbr) and abbr[indice1].isdigit():
                num = num * 10 + int(abbr[indice1])
                indice1 += 1
            
            indice0 += num
        
        return indice0 == len(word) and indice1 == len(abbr)