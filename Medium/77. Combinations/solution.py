class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        
        values = [i + 1 for i in range(n)]

        answer: List[List[int]] = []
        self.backtracking(values, [], answer, k, 0)
        return answer
    
    def backtracking(self, values: List[int], comb: List[int], answer: List[List[int]], k: int, indice: int) -> None:

        if len(comb) == k:
            answer.append(comb[::])
            return
        

        for i in range(indice, len(values)):
            comb.append(values[i])
            self.backtracking(values, comb, answer, k, i + 1)
            comb.pop()
        
        return