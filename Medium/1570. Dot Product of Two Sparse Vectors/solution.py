class SparseVector:
    def __init__(self, nums: List[int]):
        self.pairs = []

        for indice, num in enumerate(nums):
            if num == 0:
                continue
            self.pairs.append((indice, num))
        

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        
        indice1: int = 0
        indice2: int = 0
        product: int = 0
        while indice1 < len(self.pairs) and indice2 < len(vec.pairs):
            if self.pairs[indice1][0] == vec.pairs[indice2][0]:
                product += self.pairs[indice1][1] * vec.pairs[indice2][1]
                indice1 += 1
                indice2 += 1
            elif self.pairs[indice1][0] < vec.pairs[indice2][0]:
                indice1 += 1
            else:
                indice2 += 1
        
        return product