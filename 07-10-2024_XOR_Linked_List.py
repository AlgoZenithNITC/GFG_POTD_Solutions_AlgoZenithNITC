#User function Template for python3

def insert(head, data):
    if not head:
        head=Node(data)
    else:
        new_node=Node(data)
        new_node.npx=head
        head=new_node
    return head
def getList(head):
    lst=[]
    while head:
        lst.append(head.data)
        head=head.npx
    return lst
