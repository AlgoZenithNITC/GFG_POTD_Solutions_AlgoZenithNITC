class Solution {
  public:
    // Utility function to find ancestors of a target node
    bool AncestorsUtil(struct Node *root, int target, vector<int> &nodes) {
        // Base case: if root is NULL, return false
        if (root == NULL)
            return false;

        // If the target node is found, add it to the vector and return true
        if (root->data == target)
            return true;

        // Recursively check in the left and right subtrees
        // If the target node is found in any of the subtrees, add the root to the
        // vector and return true
        if (AncestorsUtil(root->left, target, nodes) ||
            AncestorsUtil(root->right, target, nodes)) {
            nodes.push_back(root->data);
            return true;
        }

        // If the target node is not found in the subtrees, return false
        return false;
    }

    // Function to find the ancestors of a target node
    vector<int> Ancestors(struct Node *root, int target) {
        // Create a vector to store the ancestors
        vector<int> nodes;

        // Call the utility function to find ancestors and store them in the vector
        AncestorsUtil(root, target, nodes);

        // Return the vector of ancestors
        return nodes;
    }
};
