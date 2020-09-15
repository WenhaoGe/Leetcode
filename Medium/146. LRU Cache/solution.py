from collections import OrderedDict
class LRUCache:

    def __init__(self, capacity: int):
        self.map = OrderedDict()
        self.capa = capacity
        
        

    def get(self, key: int) -> int:
        
        answer = self.map.get(key, -1)
        if answer == -1:
            return answer
        
        del self.map[key]
        self.map[key] = answer
        return answer
        

    def put(self, key: int, value: int) -> None:
        
        if key in self.map:
            del self.map[key]
        
        self.map[key] = value
        
        if len(self.map) > self.capa:
            key = list(self.map.items())[0][0]
            
            del self.map[key]
        return


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)