class MovingAverage:

    def __init__(self, size: int):
        self.size = size
        self.queue = collections.deque()
        self.total = 0

    def next(self, val: int) -> float:

        if len(self.queue) == self.size:
            old_val = self.queue.popleft()
            self.queue.append(val)
            self.total -= old_val
            self.total += val
            return float(self.total / self.size)
        else:
            self.queue.append(val)
            self.total += val
            return float(self.total / len(self.queue))