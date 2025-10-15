class Solution {
  private:
     int lmao=1;
  public:
    int kthSmallest(Node *root, int k) {
        // code here
        if(!root)
        {
            return -1;
        }
        //cout << lmao << "-" << root->data << endl;
        int res = kthSmallest(root->left, k);
        //cout << lmao << "-" << root->data << endl;
        if(res!=-1)
        {
            return res;
        }
        if(lmao==k)
        {
            return root->data;
        }
        else
        {
            lmao++;
        }
        //cout << lmao << "-" << root->data << endl;
        res = kthSmallest(root->right, k);
        //cout << lmao << "-" << root->data << endl;
        return res;
    }
};
