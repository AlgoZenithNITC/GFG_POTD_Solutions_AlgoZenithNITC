class Solution:
    def findIntersection(self, head1, head2):
        answer = Node(0)
        temp = answer
        while head1 and head2:
            if head1.data < head2.data:
                head1 = head1.next
            elif head1.data > head2.data:
                head2 = head2.next
            else:
                answer.next = head1
                answer = answer.next
                head1 = head1.next
                head2 = head2.next
        answer.next = None
        return temp.next
