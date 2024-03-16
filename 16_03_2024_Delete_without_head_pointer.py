class Solution:
    def deleteNode(self, del_node):
        if del_node.next is not None:
            del_node.data = del_node.next.data
            del_node.next = del_node.next.next
        else:
            del_node = None

