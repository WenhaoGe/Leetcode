class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:

        answer: List[List[int]] = []

        indice0: int = 0
        indice1: int = 0

        while indice0 < len(firstList) and indice1 < len(secondList):
            start1, end1 = firstList[indice0]
            start2, end2 = secondList[indice1]
            max_start = max(start1, start2)
            min_end = min(end1, end2)

            if min_end >= max_start:
                answer.append([max_start, min_end])
            
            if end1 < end2:
                indice0 += 1
            else:
                indice1 += 1
        
        return answer