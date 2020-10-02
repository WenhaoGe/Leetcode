class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        num, den = numerator, denominator
        
        if not den:
            return 
        if not num:
            return "0"
        res = []
        if (num < 0) ^ (den < 0):
            res.append("-")
        num, den = abs(num), abs(den)
        res.append(str(num // den))
        
        rmd = num % den
        if not rmd:
            return "".join(res)
        res.append(".")
        dic = {}
        while rmd:
            if rmd in dic:
                res.insert(dic[rmd], "(")
                res.append(")")
                break
            dic[rmd] = len(res)
            div, rmd = divmod(rmd*10, den)
            res.append(str(div))
        return "".join(res)