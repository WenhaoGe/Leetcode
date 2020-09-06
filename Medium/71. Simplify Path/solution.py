class Solution:
    def simplifyPath(self, path: str) -> str:
        
        dirs = path.split("/")
        print(dirs)
        periods = set()
        periods.add(".")
        periods.add("..")
        periods.add("")
        stack = []
        for dir in dirs:
            if dir == "..":
                if len(stack) > 0:
                    stack.pop()
            elif not dir in periods:
                stack.append(dir)
        
        print(stack)
        if len(stack) == 0:
            return "/"
        answer = ""
        while stack:
            answer = "/" + stack.pop() + answer
        
        
        return answer
        