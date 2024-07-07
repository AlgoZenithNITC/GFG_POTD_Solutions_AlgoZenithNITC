
class Solution:

    # Function to check if a node is an ancestor of the target node
    def AncestorsUtil(self, root, target, nodes):
        if root == None:
            return False

        if root.data == target:
            return True

        # Recursively check if the target is present in the left or right subtree
        if (self.AncestorsUtil(root.left, target, nodes)
                or self.AncestorsUtil(root.right, target, nodes)):
            nodes.append(
                root.data)  # Append the current node to the ancestors list
            return True

        return False

    # Function to find all ancestors of the target node
    def Ancestors(self, root, target):
        nodes = []  # Empty list to store the ancestors

        # Call the utility function to find the ancestors
        self.AncestorsUtil(root, target, nodes)

        return nodes  # Return the list of ancestors
