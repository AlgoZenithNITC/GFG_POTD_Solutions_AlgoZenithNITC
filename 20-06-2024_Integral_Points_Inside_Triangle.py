class Solution:
    def gcd(self, a, b):
        if (b == 0):
            return a
        return self.gcd(b, a%b)

    def getBoundaryCount(self, p, q):
        if p[0]==q[0]:
            return abs(p[1] - q[1]) - 1
        if p[1] == q[1]:
            return abs(p[0]-q[0]) - 1
        return self.gcd(abs(p[0]-q[0]),abs(p[1]-q[1]))-1

    def InternalCount(self, p, q, r):
        BoundaryPoints = self.getBoundaryCount(p, q) + self.getBoundaryCount(p, r) + self.getBoundaryCount(q, r) + 3;

        doubleArea = abs(p[0]*(q[1] - r[1]) + q[0]*(r[1] - p[1])  +  r[0]*(p[1] - q[1]))

        return (doubleArea - BoundaryPoints + 2)//2
