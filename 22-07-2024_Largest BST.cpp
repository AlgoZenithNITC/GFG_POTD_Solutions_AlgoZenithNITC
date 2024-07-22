// Structure to store information about a binary tree node.
struct node1
{
    int isbst;  // flag to indicate if the subtree is a binary search tree
    int size;   // size of the subtree
    int mn;     // minimum value in the subtree
    int mx;     // maximum value in the subtree
};

// Recursive function to check if a binary tree is a binary search tree and return information about the subtree.
struct node1 bst(struct Node *root)
{
    struct node1 x; // create a node1 struct
    if(root == NULL) {  // if the root is NULL (empty subtree)
        // set the attributes of x to represent an empty subtree
        x.isbst = 1;
        x.size = 0;
        x.mn = 1000000;
        x.mx = 0;
        return x;  // return x
    }
    struct node1 left = bst(root->left);   // recursively call bst on the left subtree
    struct node1 right = bst(root->right); // recursively call bst on the right subtree
    if(left.isbst == 1 && right.isbst == 1 && root->data > left.mx && root->data < right.mn) { // if both subtrees are binary search trees and the root value is within the range of the left and right subtrees
        // set the attributes of x to represent a binary search tree
        x.isbst = 1;
        x.size = 1 + left.size + right.size;  // size is the sum of sizes of left and right subtrees plus 1 for the root node
        x.mx = max(root->data,right.mx);      // maximum value is the maximum of the root value and the maximum of the right subtree
        x.mn = min(root->data,left.mn);       // minimum value is the minimum of the root value and the minimum of the left subtree
    }
    else {
        // set the attributes of x to represent a non-binary search tree
        x.isbst = 0;
        x.size = max(left.size,right.size);    // size is the maximum of the sizes of the left and right subtrees
        x.mn = 1000000;                         // invalid minimum value
        x.mx = 0;                                // invalid maximum value
    }
    return x;  // return x
};

class Solution{
    public:
    int largestBst(Node *root)
    {
        return bst(root).size;   // call the bst function and return the size of the largest binary search tree
    }
};
