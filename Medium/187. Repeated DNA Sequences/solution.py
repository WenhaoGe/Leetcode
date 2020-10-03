class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        seen = set()
        output = set()
        for i in range(len(s) - 9):
            substring = s[i:i+10]
            if substring in seen:
                output.add(substring)
            else:
                seen.add(substring)
        answer = []
        for each in output:
            answer.append(each)
        return answer 
                