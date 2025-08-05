class Solution:
    def reverseWords(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        left: int = 0
        words = []
        for right in range(len(s)):
            if s[right] == " ":
                word = "".join(s[left: right])
                words.append(word)
                left = right + 1

        word = "".join(s[left:right + 1])
        words.append(word)
        print(words)
        idx: int = 0
        for indice in range(len(words) - 1, 0, -1):
            word = words[indice]
            for char in word:
                s[idx] = char
                idx += 1
            
            s[idx] = " "
            idx += 1
        
        word = words[0]
        for char in word:
            s[idx] = char
            idx += 1
        
        return
    