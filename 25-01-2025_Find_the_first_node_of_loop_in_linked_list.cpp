class Solution {
  public:
    Node* findFirstNode(Node* head) {
        map<Node *, int> mp;
        Node * x = head;
        while(x != NULL){
            if (mp[x]){
                return x;
            }
            mp[x] = 1;
            x = x->next;
        }
        return NULL;
    }
};
