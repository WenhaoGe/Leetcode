class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        counter = collections.Counter(nums)
        unique = list(counter.keys())

        def quickSelect(left: int, right: int, target: int) -> None:

            if left >= right:
                return
            
            pivot_indice = random.randint(left, right)
            indice = partition(left, right, pivot_indice)
            if indice == target:
                return
            
            if indice > target:
                quickSelect(left, indice - 1, target)
            else:
                quickSelect(indice + 1, right, target)

        
        def partition(left: int, right: int, pivot_indice: int) -> int:

            freq = counter[unique[pivot_indice]]
            unique[pivot_indice], unique[right] = unique[right], unique[pivot_indice]
            curr = left
            for indice in range(left, right):

                if counter[unique[indice]] >= freq:
                    unique[curr], unique[indice] = unique[indice], unique[curr]
                    curr += 1
            
            unique[right], unique[curr] = unique[curr], unique[right]
            return curr

        quickSelect(0, len(unique) - 1, k)
        return unique[:k]
