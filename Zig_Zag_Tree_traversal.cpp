//User function Template for C++
/*Structure of the node of the binary tree is as
struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/

class Solution{
    public:
    
    void solve(Node* root , vector<int> &temp){
        if(!root) return;
        
        stack<Node*> s1;
        stack<Node*> s2;
        
        s1.push(root);
        
        while(s1.empty()==false||s2.empty()==false){
            while(s1.empty()==false){
                Node* curr = s1.top();
                s1.pop();
                temp.push_back(curr->data);
                if(curr->left) s2.push(curr->left);
                if(curr->right) s2.push(curr->right);
            }
            
            while(s2.empty()==false){
                Node* curr = s2.top();
                s2.pop();
                temp.push_back(curr->data);
                if(curr->right) s1.push(curr->right);
                if(curr->left) s1.push(curr->left);
            }
        }
        
        return;
    }
    
    vector <int> zigZagTraversal(Node* root)
    {
    	// Code here
    	vector<int> temp;
    	solve(root,temp);
    	
    	return temp;
    }
};
