class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        candidates = sorted(candidates)
        answer = []
        self.backtrack(candidates, 0, target, answer, [])
        return answer
        
    def backtrack(self, candidates: List[int], start: int, target: int, answer: List[List[int]], combination: List[int]) -> None:
        
        if target < 0:
            return 
        elif target == 0:
            answer.append(list(combination))
            return
        
        for i in range(start, len(candidates)):
            
            self.backtrack(candidates, i, target - candidates[i], answer, combination + [candidates[i]])