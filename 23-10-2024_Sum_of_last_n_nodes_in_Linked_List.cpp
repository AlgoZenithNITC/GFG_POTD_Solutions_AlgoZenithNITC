//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node *next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};


// } Driver Code Ends
class Solution {
  public:
    /*Structure of the node of the linled list is as

    struct Node {
        int data;
        struct Node* next;

        Node(int x){
            data = x;
            next = NULL;
        }
    };
    */
    // your task is to complete this function
    // function should return sum of last n nodes
    int sumOfLastN_Nodes(struct Node* head, int n) {
        // Code here
        int sum=0;
        int count=0;
        struct Node *ptr=head;
        while(ptr!=NULL){
            ptr=ptr->next;
            count++;
        }
        int i=0;
        ptr=head;
        while(i<count-n){
            ptr=ptr->next;
            i++;
        }
        for(i=0;i<n;i++){
            sum+=ptr->data;
            ptr=ptr->next;
        }
        return sum;
    }
};