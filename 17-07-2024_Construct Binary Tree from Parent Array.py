def createNode(parent, i, created, root):

    #base case if this node is already created.
    if created[i] is not None:
        return

    #creating a new node and setting created[i].
    created[i] = Node(i)

    #if 'i' is root, changing root pointer.
    if parent[i] == -1:
        root[0] = created[i]
        return

    #if parent is not created then we create parent first.
    if created[parent[i]] is None:
        createNode(parent, parent[i], created, root)

    #finding parent pointer.
    p = created[parent[i]]

    #if this is first child of parent, we store it as left child.
    if p.left is None:
        p.left = created[i]
    #else we store it as right child.
    else:
        p.right = created[i]


class Solution:
    #Function to construct binary tree from parent array.
    def createTree(self, parent):
        n = len(parent)

        #creating an array created[] to keep track of created nodes,
        #initializing all entries as NULL.
        created = [None for i in range(n + 1)]

        root = [None]
        for i in range(n):
            createNode(parent, i, created, root)

        #returning root of created tree.
        return root[0]