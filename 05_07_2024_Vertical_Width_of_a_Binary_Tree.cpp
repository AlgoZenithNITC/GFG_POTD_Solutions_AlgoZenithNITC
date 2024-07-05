class Solution {
  public:
    // Function to find the vertical width of a Binary Tree.
    int verticalWidth(Node* root) {
        if (root == NULL)
            return 0;
     
        int maxLevel = 0, minLevel = 0;
        queue<pair<Node*, int> > q;
        q.push({ root, 0 });
     
        while (q.empty() != true) {
            Node* cur = q.front().first;
            int count = q.front().second;
            q.pop();
     
            if (cur->left) {
                minLevel = min(minLevel, count - 1); 
                q.push({ cur->left, count - 1 });
            }
     
            if (cur->right) {
                maxLevel = max(maxLevel, count + 1);
                q.push({ cur->right, count + 1 });
            }
        }
     
        return maxLevel + abs(minLevel) + 1;
    }
};
