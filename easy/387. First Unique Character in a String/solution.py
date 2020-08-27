class Solution:
    def firstUniqChar(self, s: str) -> int:
        
        if not s or len(s) == 0:
            return -1
        dic = OrderedDict()
        for each in s:
            dic[each] = dic.get(each, 0) + 1
        
        target = ""
        for key, value in dic.items():
            if value == 1:
                target = key
                break
        if target == "":
            return -1
        
        return s.index(target)
            
            
        