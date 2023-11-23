class Solution{
  public:
    int height(Node* N){
        if(!N){
            return 0;
        }
        return N -> height;
    }
    int getbalance(Node* N){
        if(!N){
            return 0;
        }
        return height(N -> left) - height(N -> right);
    }
    Node *rightrotation(Node* a){
        Node *b = a -> left;
        Node *c = b -> right;
        b -> right = a;
        a -> left = c;
        a -> height = max(height(a -> left), height(a -> right)) + 1;
        b -> height = max(height(b -> left), height(b -> right)) + 1;
        return b;
    }
    Node *leftrotation(Node* a){
        Node *b = a -> right;
        Node *c = b -> left;
        b -> left = a;
        a -> right = c;
        a -> height = max(height(a -> left), height(a -> right)) + 1;
        b -> height = max(height(b -> left), height(b -> right)) + 1;
        return b;
    }
    Node* insertToAVL(Node* node, int data){
        if(!node){
            return new Node(data);
        }
        if(data < node -> data){
            node -> left = insertToAVL(node -> left, data);
        }else if(data > node -> data){
            node -> right = insertToAVL(node -> right, data);
        }else{
            return node;
        }
        node -> height = max(height(node -> left), height(node -> right)) + 1;
        int balance = getbalance(node);
        if(balance > 1 and data < node -> left -> data){
            return rightrotation(node);
        }
        if(balance < -1 and data > node -> right -> data){
            return leftrotation(node);
        }
        if(balance > 1 and data > node -> left -> data){
            node -> left = leftrotation(node -> left);
            return rightrotation(node);
        }
        if(balance < -1 and data < node -> right -> data){
            node -> right = rightrotation(node -> right);
            return leftrotation(node);
        }
        return node;
    }
};
