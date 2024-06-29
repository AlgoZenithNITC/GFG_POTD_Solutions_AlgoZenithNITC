#Function to check whether two linked lists are identical or not.
def areIdentical(head1, head2):

    #traversing through both the linked lists.
    while head1 != None and head2 != None:

        #if data for current node in both lists are not equal, we return false.
        if head1.data != head2.data:
            return 0
        head1 = head1.next
        head2 = head2.next

    #if both lists reach end after same number of traversals


#then true is returned else false.
    return head1 == None and head2 == None
