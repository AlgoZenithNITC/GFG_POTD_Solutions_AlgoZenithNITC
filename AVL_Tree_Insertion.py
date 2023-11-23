class Solution:
    def height(self, N):
        if N is None:
            return 0
        return N.height
        
    def getBalance(self, N):
        if N is None:
            return 0
        return self.height(N.left) - self.height(N.right)

    def rightRotate(self, y):
        x = y.left
        T2 = x.right
        x.right = y
        y.left = T2
        y.height = max(self.height(y.left), self.height(y.right)) + 1
        x.height = max(self.height(x.left), self.height(x.right)) + 1
        return x

    def leftRotate(self, x):
        y = x.right
        T2 = y.left
        y.left = x
        x.right = T2
        x.height = max(self.height(x.left), self.height(x.right)) + 1
        y.height = max(self.height(y.left), self.height(y.right)) + 1
        return y

    def insertToAVL(self, node, data):
        if node is None:
            return Node(data)
        if data < node.data:
            node.left = self.insertToAVL(node.left, data)
        elif data > node.data:
            node.right = self.insertToAVL(node.right, data)
        else:
            return node
        node.height = 1 + max(self.height(node.left), self.height(node.right))
        balance = self.getBalance(node)
        if balance > 1 and data < node.left.data:
            return self.rightRotate(node)
        if balance < -1 and data > node.right.data:
            return self.leftRotate(node)
        if balance > 1 and data > node.left.data:
            node.left = self.leftRotate(node.left)
            return self.rightRotate(node)
        if balance < -1 and data < node.right.data:
            node.right = self.rightRotate(node.right)
            return self.leftRotate(node)
        return node
