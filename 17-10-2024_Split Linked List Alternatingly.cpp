
/* C++ Program to alternatively split
a linked list into two halves */
#include <bits/stdc++.h>
using namespace std;

/* Link list node */
class Node 
{ 
	public:
	int data; 
	Node* next; 
}; 

/* pull off the front node of
the source and put it in dest */
void MoveNode(Node** destRef, Node** sourceRef) ; 

/* Given the source list, split its
nodes into two shorter lists. If we number
the elements 0, 1, 2, ... then all the even
elements should go in the first list, and 
all the odd elements in the second. The 
elements in the new lists may be in any order. */
void AlternatingSplit(Node* source, Node** aRef, 
							Node** bRef) 
{ 
	/* split the nodes of source 
	to these 'a' and 'b' lists */
	Node* a = NULL; 
	Node* b = NULL; 
		
	Node* current = source; 
	while (current != NULL) 
	{ 
		MoveNode(&a, ¤t); /* Move a node to list 'a' */
		if (current != NULL) 
		{ 
			MoveNode(&b, ¤t); /* Move a node to list 'b' */
		} 
	} 
	*aRef = a; 
	*bRef = b; 
} 

/* Take the node from the front of
the source, and move it to the front
of the dest. It is an error to call
this with the source list empty. 
	
Before calling MoveNode(): 
source == {1, 2, 3} 
dest == {1, 2, 3} 
		
After calling MoveNode(): 
source == {2, 3}	 
dest == {1, 1, 2, 3}	 
*/
void MoveNode(Node** destRef, Node** sourceRef) 
{ 
	/* the front source node */
	Node* newNode = *sourceRef; 
	assert(newNode != NULL); 
		
	/* Advance the source pointer */
	*sourceRef = newNode->next; 
		
	/* Link the old dest of the new node */
	newNode->next = *destRef; 
		
	/* Move dest to point to the new node */
	*destRef = newNode; 
} 

/* UTILITY FUNCTIONS */
/* Function to insert a node at 
the beginning of the linked list */
void push(Node** head_ref, int new_data) 
{ 
	/* allocate node */
	Node* new_node = new Node();
	
	/* put in the data */
	new_node->data = new_data; 
	
	/* link the old list of the new node */
	new_node->next = (*head_ref);	 
	
	/* move the head to point to the new node */
	(*head_ref) = new_node; 
} 

/* Function to print nodes
in a given linked list */
void printList(Node *node) 
{ 
	while(node!=NULL) 
	{ 
	cout<<node->data<<" "; 
	node = node->next; 
	} 
} 

/* Driver code*/
int main() 
{ 
	/* Start with the empty list */
	Node* head = NULL; 
	Node* a = NULL; 
	Node* b = NULL; 
	
	/* Let us create a sorted linked list to test the functions 
	Created linked list will be 0->1->2->3->4->5 */
	push(&head, 5); 
	push(&head, 4); 
	push(&head, 3); 
	push(&head, 2); 
	push(&head, 1);								 
	push(&head, 0); 
	
	cout<<"Original linked List: "; 
	printList(head); 
	
	/* Remove duplicates from linked list */
	AlternatingSplit(head, &a, &b); 
	
	cout<<"\nResultant Linked List 'a' : "; 
	printList(a);		 
	
	cout<<"\nResultant Linked List 'b' : "; 
	printList(b);		 
	
	return 0; 
} 

// This code is contributed by rathbhupendra
