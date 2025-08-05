class Solution:
    def areSentencesSimilar(self, sentence1: List[str], sentence2: List[str], similarPairs: List[List[str]]) -> bool:

        if len(sentence1) != len(sentence2):
            return False
        
        unique = set()
        for pair in similarPairs:
            unique.add(tuple(pair))
        
        print(unique)
        
        for indice in range(len(sentence1)):
            word1 = sentence1[indice]
            word2 = sentence2[indice]
            print("word1: ", word1, " word2: ", word2)
            if word1 != word2 and not (word1, word2) in unique and not (word2, word1) in unique:
                return False
        
        return True