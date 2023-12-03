class Solution{
public:
    int countPairs(Node* root1, Node* root2, int x){
        if(root1 == NULL or root2 == NULL){
            return 0;
        }
        stack<Node*> bst1, bst2;
        Node *top1, *top2;
        int count = 0;
        while(true){
            while(root1){
                bst1.push(root1);
                root1 = root1 -> left;
            }
            while(root2){
                bst2.push(root2);
                root2 = root2 -> right;
            }
            if(bst1.empty() or bst2.empty()){
                break;
            }
            top1 = bst1.top();
            top2 = bst2.top();
            if(top1 -> data + top2 -> data == x){
                count++;
                bst1.pop();
                bst2.pop();
                root1 = top1 -> right;
                root2 = top2 -> left;
            }else if(top1 -> data + top2 -> data < x){
                bst1.pop();
                root1 = top1 -> right;
            }else{
                bst2.pop();
                root2 = top2 -> left;
            }
        }
        return count;
    }
};
