class Solution:
    def generateBinary(self, n):
        result = []
        q = deque(["1"])

        for _ in range(n):
            curr = q.popleft()
            result.append(curr)

            q.append(curr + "0")
            q.append(curr + "1")

        return result