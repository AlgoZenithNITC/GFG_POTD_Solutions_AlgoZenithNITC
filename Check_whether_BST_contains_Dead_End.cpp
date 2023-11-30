class Solution{
    public:
    bool has_dead_end(Node *root, int min_val, int max_val){
        if(root == NULL){
            return false;
        }
        if(min_val == max_val){
            return true;
        }
        return has_dead_end(root -> left, min_val, root -> data - 1) or
        has_dead_end(root -> right, root -> data + 1, max_val);
    }
    bool isDeadEnd(Node *root){
        return has_dead_end(root, 1, 10001);
    }
};
