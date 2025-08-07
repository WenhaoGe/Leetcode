class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:

        self.quickSelect(points, 0, len(points) - 1, k)
        return points[:k]

    def quickSelect(self, points: List[List[int]], left: int, right: int, target: int) -> None:

        if left < right:

            pivot = self.partition(points, left, right)
            if pivot == target:
                return
            
            if pivot > target:
                self.quickSelect(points, left, pivot - 1, target)
            else:
                self.quickSelect(points, pivot + 1, right, target)
    

    def partition(self, points: List[List[int]], left: int, right: int) -> int:

        pivot = points[right]
        curr = left

        for i in range(left, right):
            point = points[i]
            if point[0] **2 + point[1] **2 < pivot[0] **2 + pivot[1] ** 2:
                points[curr], points[i] = points[i], points[curr]
                curr += 1
        
        points[curr], points[right] = points[right], points[curr]
        return curr

