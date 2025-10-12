#include <iostream>
using namespace std;

// Node Structure
class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int x) {
        data = x;
        left = right = nullptr;
    }
};

// function to find the number of
// moves to distribute all of the candies
int distCandyUtil(Node* root, int& ans) {
  
    if (root == nullptr)
        return 0;

    // Traverse left subtree
    int l = distCandyUtil(root->left, ans);

    // Traverse right subtree
    int r = distCandyUtil(root->right, ans);

    ans += abs(l) + abs(r);

    // Return number of moves to balance
    // current node
    return root->data + l + r - 1;
}

// Function to find the number of moves
int distCandy(Node* root) {
    int ans = 0;
    distCandyUtil(root, ans);
    return ans;
}

int main() {
    
     
   // Representation of given Binary Tree
//        5
//       / \
//      0   0
//         / \
//        0   0
    Node* root = new Node(5);
    root->left = new Node(0);
    root->right = new Node(0);
    root->right->left = new Node(0);
    root->right->right = new Node(0);

    cout << distCandy(root);

    return 0;
}
