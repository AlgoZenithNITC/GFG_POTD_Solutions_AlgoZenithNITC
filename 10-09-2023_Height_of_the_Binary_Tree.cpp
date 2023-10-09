class Solution{
    public:
    //Function to find the height of a binary tree.
    int height(struct Node* node){
        if(node == NULL){
            return 0;
        }
        return 1 + max(height(node -> left), height(node -> right));
    }
};
