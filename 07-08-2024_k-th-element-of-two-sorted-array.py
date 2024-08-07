def kth(arr1, arr2, s1, e1, s2, e2, k):
    #Base cases
    #If array 1 is reduced to a single element, return the kth element from array 2
    if s1 == e1:
        return arr2[s2 + k]
    #If array 2 is reduced to a single element, return the kth element from array 1
    if s2 == e2:
        return arr1[s1 + k]

    #Finding the middle indices of both arrays
    m1 = (e1 - s1) // 2
    m2 = (e2 - s2) // 2

    #If the sum of the middle indices is less than k
    if m1 + m2 < k:
        #Check if the element at middle index of array 1 is greater than the element at middle index of array 2
        if arr1[s1 + m1] > arr2[s2 + m2]:
            #Recursively find the kth element, excluding the first half of array 2
            return kth(arr1, arr2, s1, e1, s2 + m2 + 1, e2, k - m2 - 1)
        else:
            #Recursively find the kth element, excluding the first half of array 1
            return kth(arr1, arr2, s1 + m1 + 1, e1, s2, e2, k - m1 - 1)

    #If the sum of the middle indices is greater than or equal to k
    else:
        #Check if the element at middle index of array 1 is greater than the element at middle index of array 2
        if arr1[s1 + m1] > arr2[s2 + m2]:
            #Recursively find the kth element, excluding the second half of array 1
            return kth(arr1, arr2, s1, s1 + m1, s2, e2, k)
        else:
            #Recursively find the kth element, excluding the second half of array 2
            return kth(arr1, arr2, s1, e1, s2, s2 + m2, k)


class Solution:
    #Function to find the kth element from two sorted arrays.
    def kthElement(self, k, arr1, arr2):
        return kth(arr1, arr2, 0, len(arr1), 0, len(arr2), k - 1)
