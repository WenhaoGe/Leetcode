class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        
        map = {}
        for path in paths:
            values = path.split(" ")
            directory = values[0]
            for i in range(1, len(values)):
                file = values[i]
                index = file.index("(")
                filename = file[0:index]
                filedirectory = directory + "/" + filename
                content = file[index+1: len(file) - 1]
                map[content] = map.get(content, []) + [filedirectory]
        
        answer = []
        for k,v in map.items():
            if len(v) >= 2:
                answer.append(list(v))
                
        
        return answer
            
        