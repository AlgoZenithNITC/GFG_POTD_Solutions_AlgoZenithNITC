/*The Node structure is
class Node
{
    int data;
    struct Node *left;
    struct Node *right;

    Node(int x){
        data = x;
        left = NULL;
        right = NULL;
    }
};*/

class Solution {
  public:
    bool isDeadEnd(Node *root) {
        // Code here
        queue<pair<Node *, pair<int, int>>> q;
        q.push({root, {1, int(pow(10, 5))}});
        while(!q.empty())
        {
            Node * cur = q.front().first;
            int min = q.front().second.first;
            int max = q.front().second.second;
            q.pop();
            if(cur->left==NULL && cur->right==NULL)
            {
                if(min==max)
                {
                    return true;
                }
            }
            if(cur->left)
            {
                q.push({cur->left, {min, cur->data-1}});
            }
            if(cur->right)
            {
                q.push({cur->right, {cur->data+1, max}});
            }
        }
        return false;;
    }
};