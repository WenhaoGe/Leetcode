class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        counter = collections.Counter(nums)

        minHeap = []

        for key, value in counter.items():

            heapq.heappush(minHeap, (value, key))

            if len(minHeap) > k:
                heapq.heappop(minHeap)
        

        answer: List[int] = []

        while minHeap:
            freq, number = heapq.heappop(minHeap)
            answer.append(number)
        
        return answer