class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        if not strs or len(strs) == 0:
            return []
        map = {}
        def helper(value):
            
            key = str(sorted(value))
            map[key] = map.get(key, []) + [value]
                        
        for value in strs:
            helper(value)
        
        answer = []
        for _, v in map.items():
            answer.append(list(v))
        return answer
        
            
        