
class Solution{
    public:
    
    Node* find_nearest_common_root(Node* root , int a , int b){
        if(root==NULL||root->data==a||root->data==b)
        return root ;
        
        Node* l = find_nearest_common_root(root->left , a, b);
        Node* r = find_nearest_common_root(root->right, a, b);
        
        if(l==NULL)
        return r;
        else if(r==NULL)
        return l;
        else 
        return root ;
    }
    
    int find_dis(Node* root , int n){
        if(root==NULL) return 0;
        
        if(root->data==n) return 1;
        
        int p = find_dis(root->left,n);
        int q = find_dis(root->right,n);
        
        if(p==0 and q==0) return 0;
        
        return p+q+1;
    }
    
    /* Should return minimum distance between a and b
    in a tree with given root*/
    int findDist(Node* root, int a, int b) {
        // Your code here
        
        Node* LCA = find_nearest_common_root(root,a,b);
        
        return find_dis(LCA,a)+find_dis(LCA,b) -2;
    }
};
