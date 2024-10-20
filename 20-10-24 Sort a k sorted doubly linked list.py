class Compare:
    def __call__(self, a, b):
        return a.data > b.data

# function to sort a k sorted doubly linked list
def sort_k_sorted_dll(head, k):
    
    # if list is empty
    if head is None:
        return head

    # priority_queue 'pq' implemented as 
    # min heap with the
    # help of 'compare' function
    pq = []
    heapq.heapify(pq)
    
    def heap_push(node):
        heapq.heappush(pq, (node.data, node))

    def heap_pop():
        return heapq.heappop(pq)[1]

    new_head = None
    last = None

    # Create a Min Heap of first (k+1) elements from
    # input doubly linked list
    for i in range(k + 1):
        if head is None:
            break
        heap_push(head)
        head = head.next

    while pq:
        
        # place root or top of 'pq' at the end of the
        # result sorted list so far having the first node
        # pointed to by 'newHead'
        # and adjust the required links
        if new_head is None:
            new_head = heap_pop()
            new_head.prev = None
            last = new_head
        else:
            last.next = heap_pop()
            last.next.prev = last
            last = last.next

        # if there are more nodes left in the input list
        if head is not None:
            heap_push(head)
            head = head.next

    # making 'next' of last node point to NULL
    last.next = None

    # new head of the required sorted DLL
    return new_head
