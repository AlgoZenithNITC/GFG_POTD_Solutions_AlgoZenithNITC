# Python program to alternatively split 
# a linked list into two halves 

# Node class
class Node:
	
	def __init__(self, data, next = None):
		
		self.data = data
		self.next = None

class LinkedList:
	
	def __init__(self):
		
		self.head = None
	
	# Given the source list, split its 
	# nodes into two shorter lists. If we number 
	# the elements 0, 1, 2, ... then all the even 
	# elements should go in the first list, and 
	# all the odd elements in the second. The 
	# elements in the new lists may be in any order.
	def AlternatingSplit(self, a, b):
		
		first = self.head
		second = first.next
		
		while (first is not None and
			second is not None and
		first.next is not None):
			
			# Move a node to list 'a'
			self.MoveNode(a, first) 
			
			# Move a node to list 'b'
			self.MoveNode(b, second) 
			
			first = first.next.next
			
			if first is None:
				break
			
			second = first.next
			
	# Pull off the front node of the 
	# source and put it in dest
	def MoveNode(self, dest, node):
		
		# Make the new node
		new_node = Node(node.data)
		
		if dest.head is None:
			dest.head = new_node
		else:
			
			# Link the old dest of the new node 
			new_node.next = dest.head
			
			# Move dest to point to the new node 
			dest.head = new_node

	# UTILITY FUNCTIONS 
	# Function to insert a node at 
	# the beginning of the linked list 
	def push(self, data):
		
		# 1 & 2 allocate the Node & 
		# put the data
		
		new_node = Node(data)
		
		# Make the next of new Node as head
		new_node.next = self.head
		
		# Move the head to point to new Node
		self.head = new_node
		
	# Function to print nodes 
	# in a given linked list 
	def printList(self):
		
		temp = self.head
		while temp:
			print temp.data,
			temp = temp.next
			
		print("")

# Driver Code
if __name__ == "__main__":
	
	# Start with empty list
	llist = LinkedList()
	a = LinkedList()
	b = LinkedList()
	
	# Created linked list will be
	# 0->1->2->3->4->5 
	llist.push(5)
	llist.push(4)
	llist.push(3)
	llist.push(2)
	llist.push(1)
	llist.push(0)
	
	llist.AlternatingSplit(a, b)
	
	print "Original Linked List: ",
	llist.printList()
	
	print "Resultant Linked List 'a' : ",
	a.printList()
	
	print "Resultant Linked List 'b' : ",
	b.printList()
	
# This code is contributed by kevalshah5
