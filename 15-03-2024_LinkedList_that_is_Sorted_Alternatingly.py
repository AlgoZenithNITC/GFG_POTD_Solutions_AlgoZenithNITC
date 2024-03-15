class Node:
    def __init__(self,data):
        self.data=data
        self.next=None
class Solution:
    def sort(self, h1):
        arr=[]
        new=h1
        while new:
            arr.append(new.data)
            new=new.next
        e=sorted(arr)
        for i in range(len(e)):
            print(e[i], end=" ")
