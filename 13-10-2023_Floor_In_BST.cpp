class Solution{
public:
    int floor(Node* root, int x){
        if(root == NULL){
            return -1;
        }
        int temp, present = INT_MIN;
        if(root -> data > x){
            temp = floor(root -> left, x);
        }else if(root -> data <= x){
            present = root -> data;
            temp = floor(root -> right, x);
        }
        return max(present, temp);
    }
};
