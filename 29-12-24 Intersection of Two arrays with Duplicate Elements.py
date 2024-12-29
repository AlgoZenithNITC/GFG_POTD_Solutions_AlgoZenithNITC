def intersectionWithDuplicates(self, a, b):
    a=set(a)
    ans=[]
    for item in b:
        if item in a:
            ans.append(item)
            a.remove(item)
    return ans
