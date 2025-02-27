# Python program to implement a stack that supports
# all operations in O(1) time and O(n) extra space.

class SpecialStack:
    def __init__(self):
        self.s = []

    # Add an element to the top of Stack
    def push(self, x):
        newMin = x if not self.s else min(x, self.s[-1][1])
        self.s.append((x, newMin))

    # Remove the top element from the Stack
    def pop(self):
        if self.s:
            self.s.pop()

    # Returns top element of the Stack
    def peek(self):
        return -1 if not self.s else self.s[-1][0]

    # Finds minimum element of Stack
    def getMin(self):
        return -1 if not self.s else self.s[-1][1]

if __name__ == "__main__":
    ss = SpecialStack()
    # Function calls
    ss.push(2)
    ss.push(3)
    print(ss.peek(), end=" ")
    ss.pop()
    print(ss.getMin(), end=" ")
    ss.push(1)
    print(ss.getMin(), end=" ")