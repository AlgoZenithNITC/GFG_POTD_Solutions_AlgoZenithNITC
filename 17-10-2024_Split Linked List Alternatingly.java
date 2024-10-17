import java.util.*;

// Linked list node
class Node {
int data;
Node next;

Node(int data) {
	this.data = data;
	next = null;
}
}

class Main
{

// Given the source list, split its nodes into two shorter lists.
// All the even elements should go in the first list, and all the odd
// elements in the second. The elements in the new lists may be in any order.
static void AlternatingSplit(Node source, Node[] aRef, Node[] bRef) {
	Node a = null, b = null;
	Node current = source;
	int count = 0;

	while (current != null) {
	if (count % 2 == 0) {
		// Move a node to list 'a'
		if (a == null) {
		aRef[0] = current;
		a = current;
		} else {
		a.next = current;
		a = a.next;
		}
	} else {
		// Move a node to list 'b'
		if (b == null) {
		bRef[0] = current;
		b = current;
		} else {
		b.next = current;
		b = b.next;
		}
	}
	current = current.next;
	count++;
	}

	if (a != null) {
	a.next = null;
	}

	if (b != null) {
	b.next = null;
	}
}

// Function to print nodes in a given linked list
static void printList(Node node) {
	while (node != null) {
	System.out.print(node.data + " ");
	node = node.next;
	}
}

// Driver code
public static void main(String[] args)
{
	
	// Start with the empty list
	Node head = null;

	// Let us create a sorted linked list to test the functions
	// Created linked list will be 0->1->2->3->4->5
	for (int i = 5; i >= 0; i--) {
	Node newNode = new Node(i);
	newNode.next = head;
	head = newNode;
	}

	System.out.print("Original linked List: ");
	printList(head);

	Node[] aRef = new Node[1];
	Node[] bRef = new Node[1];

	// Remove duplicates from linked list
	AlternatingSplit(head, aRef, bRef);

	System.out.print("\nResultant Linked List 'a': ");
	printList(aRef[0]);

	System.out.print("\nResultant Linked List 'b': ");
	printList(bRef[0]);
}
}
