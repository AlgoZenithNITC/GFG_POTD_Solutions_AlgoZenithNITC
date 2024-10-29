def quickSort(head):
    if not head or not head.next:
        return head
    
    pivot = head.data
    less_head = less_tail = Node(0) 
    equal_head = equal_tail = Node(0)  
    greater_head = greater_tail = Node(0)  

    current = head
    while current:
        if current.data < pivot:
            less_tail.next = current
            less_tail = less_tail.next
        elif current.data == pivot:
            equal_tail.next = current
            equal_tail = equal_tail.next
        else:
            greater_tail.next = current
            greater_tail = greater_tail.next
        current = current.next

    less_tail.next = None
    equal_tail.next = None
    greater_tail.next = None

    sorted_less = quickSort(less_head.next)
    sorted_greater = quickSort(greater_head.next)

    if sorted_less:
        head = sorted_less
        less_tail = sorted_less
        while less_tail.next:
            less_tail = less_tail.next
        less_tail.next = equal_head.next
    else:
        head = equal_head.next

    if equal_head.next:
        equal_tail = equal_head.next
        while equal_tail.next:
            equal_tail = equal_tail.next
        equal_tail.next = sorted_greater

    return head