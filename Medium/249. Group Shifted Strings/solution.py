class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        
        collection = defaultdict()
        for string in strings:
            key = ""
            for i in range(len(string) - 1):
                diff = ord(string[i + 1]) - ord(string[i]) + 26
                key += str(diff % 26)
            
            collection[key] = collection.get(key, []) + [string]
        
        return list(collection.values())
        