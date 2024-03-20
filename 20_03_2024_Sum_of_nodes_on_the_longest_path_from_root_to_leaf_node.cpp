class Solution
{
    private:
    void  solve(Node* root,int sum,int length,int &maxsum,int &maxlength)
    {
        if(root==NULL)
        {
            if(maxlength==length)
            {
                maxsum=max(maxsum,sum);
            }
            else if(maxlength<length)
            {
                maxsum=sum;
                maxlength=length;
            }
            return;
        }
        sum=sum+root->data;
        length=length+1;
        solve(root->left,sum,length,maxsum,maxlength);
        solve(root->right,sum,length,maxsum,maxlength);
    }
public:
    
    int sumOfLongRootToLeafPath(Node *root)
    {
        //code here
        int sum=0;
        int length=0;
        int maxsum=0;
        int maxlength=0;
        solve(root,sum,length,maxsum,maxlength);
        return maxsum;
    }
};
