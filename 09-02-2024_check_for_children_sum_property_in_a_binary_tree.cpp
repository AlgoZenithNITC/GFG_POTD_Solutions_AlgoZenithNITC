class Solution{
    public:
    int isSumProperty(Node *root)
    {
     if(root==NULL) return 1;
     
     if(root->left==NULL && root->right==NULL) return 1;
     
     int sum=0;
     
     if(root->left!=NULL) sum+=root->left->data;
     if(root->right!=NULL) sum+=root->right->data;
     
     return (sum==root->data && isSumProperty(root->left) && isSumProperty(root->right)) ;
    
    }
};
