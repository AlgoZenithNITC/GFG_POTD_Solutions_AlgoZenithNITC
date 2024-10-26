/*
  Node is defined as
struct node
{
    int data;
    struct node* next;

    node(int x){
        data = x;
        next = NULL;
    }
}*head;
*/
class Solution {
  public:
    int count(struct Node* head, int key) {
        struct Node*temp=head;
        int counter=0;
        while(temp){
            if(temp->data==key){
                counter++;
            }
            temp=temp->next;
        }
        return counter;
    }
};