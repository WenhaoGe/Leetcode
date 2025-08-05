class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        
        records = dict()
        answer: List[List[str]] = []

        for _, string in enumerate(strings):
            key = []
            for indice in range(1, len(string)):
                diff = ord(string[indice]) - ord(string[indice - 1]) + 26
                key.append(str(diff % 26))
            
            new_key = ",".join(key)
            if not new_key in records:
                records[new_key] = []
            records[new_key].append(string)
        
        for key, values in records.items():
            answer.append(values)
        
        return answer
            