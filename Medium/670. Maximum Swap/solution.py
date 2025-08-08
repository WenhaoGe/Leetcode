class Solution:
    def maximumSwap(self, num: int) -> int:
        
        records = dict()

        digits = list(str(num))

        for indice, digit in enumerate(digits):
            records[int(digit)] = indice
        
        for indice, digit in enumerate(digits):
            for value in range(9, int(digit), -1):
                if records.get(value, -1) > indice:
                    idx = records[value]
                    digits[indice], digits[idx] = digits[idx], digits[indice]
                    return int("".join(digits))
        

        return num