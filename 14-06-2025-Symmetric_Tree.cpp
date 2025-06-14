class Solution {
  public:
  bool recsym(Node * p,Node * q)
    {
         if(p==nullptr && q==nullptr)
        {
            return true;
        }

        if(p && !q || q && !p || p->data!=q->data)
        {
            return false;
        }

        return recsym(p->left,q->right) && recsym(p->right,q->left);
    }


    bool isSymmetric(Node* root) 
    {
        if(root==nullptr)
            return true;

        return recsym(root->left,root->right);
    }
   
};
