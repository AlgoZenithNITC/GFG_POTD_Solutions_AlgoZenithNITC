class Solution:
    def sortedMerge(self, head1, head2):
        # Initialize pointers for the new merged list
        head3 = None  # Head of the merged list
        temp = None   # Temporary pointer to track the tail of the merged list

        # Traverse both lists while there are nodes in both
        while head1 is not None and head2 is not None:
            if head3 is None:
                if head1.data > head2.data:
                    head3 = head2
                    head2 = head2.next
                else:
                    head3 = head1
                    head1 = head1.next
                temp = head3
            else:
                if head1.data > head2.data:
                    temp.next = head2
                    head2 = head2.next
                else:
                    temp.next = head1
                    head1 = head1.next
                temp = temp.next

        # Attach the remaining nodes of either list
        if head1 is not None:
            temp.next = head1
        elif head2 is not None:
            temp.next = head2

        return head3

