class Solution:
    def simplifyPath(self, path: str) -> str:

        components = path.split("/")
        store = []
        for component in components:
            if component == '.' or component == '':
                continue
            
            elif component == '..':
                if len(store) > 0:
                    store.pop()
            else:
                store.append(component)
        
        print(store)

        return "/" + "/".join(store)