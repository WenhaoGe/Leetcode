class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        if not candidates or len(candidates) == 0:
            return []
        candidates = sorted(candidates)
        
        answer = []
        self.backtrack(candidates, target, 0, answer, [])
        return answer
        
    def backtrack(self, candidates: List[int], target: int, start: int, answer: List[List[int]], combination: List[int]) -> None:
        
        if target < 0:
            return
        if target == 0:
            answer.append(list(combination))
            return
        
        for i in range(start, len(candidates)):
            if i > start and candidates[i] == candidates[i - 1]:
                continue
            self.backtrack(candidates, target - candidates[i], i + 1, answer, combination + [candidates[i]])
        
        return
        