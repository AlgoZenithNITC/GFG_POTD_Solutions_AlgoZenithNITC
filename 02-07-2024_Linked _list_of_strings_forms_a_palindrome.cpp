class Solution {
  private:
    bool ispalindrome(string str)
    {
        int n=str.length();
        for(int i=0;i<n/2;i++)
        {
            if(str[i]!=str[n-i-1]) return false;
        }
        return true;
    }
    
    bool converttostring(Node* head)
    {
       Node* temp=head;
       string str;
       while(temp!=NULL)
       {
           str+=temp->data;
           temp=temp->next;
       }
       return ispalindrome(str);
    }
    
  public:
    bool compute(Node* head) {
        return converttostring(head);
    }
};
