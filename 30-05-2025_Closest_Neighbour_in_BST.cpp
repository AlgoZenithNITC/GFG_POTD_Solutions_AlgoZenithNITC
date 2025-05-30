int findMaxFork(Node* root, int k) {
    int ans = -1;
    Node *curr = root;
    while(curr != NULL){
        if(k < curr->data){
            curr = curr->left;
        }
        else{
            ans = curr->data;
            curr = curr->right;
        }
    }
    
    return ans;
}
