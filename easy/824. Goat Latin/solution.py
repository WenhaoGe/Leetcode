class Solution:
    def toGoatLatin(self, sentence: str) -> str:

        components = sentence.strip().split()

        words = ["" for _ in range(len(components))]

        for indice, comp in enumerate(components):
            if comp[0].lower() in "aeiou":
                words[indice] = comp + "ma" + (indice + 1) * 'a'
            else:
                words[indice] = comp[1:] + comp[0] + "ma" + (indice + 1) * 'a'
        
        return " ".join(words)