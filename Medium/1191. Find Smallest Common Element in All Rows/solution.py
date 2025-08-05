class Solution:
    def smallestCommonElement(self, mat: List[List[int]]) -> int:
        
        row = mat[0]
        
        for element in row:
            smallest_element = True
            for indice in range(1, len(mat)):
                next_row = mat[indice]
                if not self.binarySearch(next_row, element):
                    smallest_element = False
                
                if not smallest_element:
                    break
            
            if smallest_element:
                return element
        
        return -1
    

    def binarySearch(self, row: List[int], target: int) -> bool:

        left: int = 0
        right: int = len(row) - 1

        while left <= right:
            mid = (left + right) // 2
            if row[mid] == target:
                return True
            
            if row[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        
        return False
