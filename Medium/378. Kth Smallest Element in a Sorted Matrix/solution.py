class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        minHeap = []
        N = len(matrix)

        for row in range(min(k, N)):
            heapq.heappush(minHeap, (matrix[row][0], row, 0))
        
        while k > 0:

            value, row, col = heapq.heappop(minHeap)
            if col + 1 < N:
                heapq.heappush(minHeap, (matrix[row][col+1], row, col+1))
            
            k -= 1
        
        return value