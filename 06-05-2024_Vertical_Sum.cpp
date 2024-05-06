
class Solution{
  public:
      void verticalSumCal(Node *root,vector<int>& v,int val){
             if(root==NULL){
                 return;
             }
             v[val]=v[val]+root->data;
            verticalSumCal(root->left,v,val-1);
            verticalSumCal(root->right,v,val+1);
             
      }
    vector <int> verticalSum(Node *root) {
        vector<int> v(20000,0);
         verticalSumCal(root,v,10000);
         vector<int> v1;
         for(int i=0;i<20000;i++){
             if(v[i]!=0){
             v1.push_back(v[i]);
             }
         }
         return v1;
    }
};

