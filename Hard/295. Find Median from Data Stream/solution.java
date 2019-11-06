class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        } else {
            int val1 = minHeap.peek();
            int val2 = maxHeap.peek();
            return (double) (val1 + val2) / 2;
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */

/**
 * Solution 2
 */

class MedianFinder {

    /** initialize your data structure here. */
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        int size = list.size();
        if (size % 2 == 1) {
            int mid = (size - 1) / 2;
            return (double) list.get(mid);
        } else {
            int mid = (size - 1) / 2;
            int val1 = list.get(mid);
            int val2 = list.get(mid + 1);
            return (double) (val1 + val2) / 2;
        }
    }
}