class Solution {
  public:
    
    Node* bintree2listUtil(Node* root)
{
    // Base case
    if (root == NULL)
        return root;
 
    // Convert the left subtree and link to root
    if (root->left != NULL) {
        // Convert the left subtree
        Node* left = bintree2listUtil(root->left);
 
        // Find inorder predecessor. After this loop, left
        // will point to the inorder predecessor
        for (; left->right != NULL; left = left->right)
            ;
 
        // Make root as next of the predecessor
        left->right = root;
 
        // Make predecessor as previous of root
        root->left = left;
    }
 
    // Convert the right subtree and link to root
    if (root->right != NULL) {
        // Convert the right subtree
        Node* right = bintree2listUtil(root->right);
 
        // Find inorder successor. After this loop, right
        // will point to the inorder successor
        for (; right->left != NULL; right = right->left)
            ;
 
        // Make root as previous of successor
        right->left = root;
 
        // Make successor as next of root
        root->right = right;
    }
 
    return root;
}


    Node* bToDLL(Node* root) {
        if (root == NULL)
            return root;
     
        // Convert to DLL using bintree2listUtil()
        root = bintree2listUtil(root);
     
        // bintree2listUtil() returns root node of the converted
        // DLL. We need pointer to the leftmost node which is
        // head of the constructed DLL, so move to the leftmost
        // node
        while (root->left != NULL)
            root = root->left;
     
        return (root);
    }
};
