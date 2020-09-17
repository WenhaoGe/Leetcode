class Solution:
    def minFlips(self, target: str) -> int:
        
        length = len(target)
        status = "0"
        flips = 0
        for i in range(len(target)):
            if target[i] != status:
                flips += 1
                if status == "0":
                    status = "1"
                else:
                    status = "0"
        
        return flips
        