class Solution
{
    public:
        // Should return decimal equivalent modulo 1000000007 of binary linked list 
        long long unsigned int decimalValue(Node *head)
        {
           Node* temp = head;
           long long num = 0;
           while(temp != NULL)
           {
               num = (num * 2 + temp->data) % 1000000007;
               temp = temp->next;
           }
           return num;
        }
};
