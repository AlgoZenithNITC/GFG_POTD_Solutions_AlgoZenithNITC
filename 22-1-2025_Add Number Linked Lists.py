class Solution:
    def reverse(self, head):
        prev = None
        current = head
        next = None

        while current is not None:
            next = current.next
            current.next = prev
            prev = current
            current = next

        return prev

    def addTwoLists(self, num1, num2):
        num1 = self.reverse(num1)
        num2 = self.reverse(num2)

        sumList = None
        carry = 0

        while num1 is not None or num2 is not None or carry > 0:
            newVal = carry

            if num1 is not None:
                newVal += num1.data
            if num2 is not None:
                newVal += num2.data

            carry = newVal // 10
            newVal = newVal % 10

            newNode = Node(newVal)
            newNode.next = sumList
            sumList = newNode

            if num1:
                num1 = num1.next
            if num2:
                num2 = num2.next

        while sumList is not None and sumList.data == 0:
            temp = sumList.next
            sumList.next = None
            sumList = temp

        if sumList is None:
            return Node(0)
        return sumList
