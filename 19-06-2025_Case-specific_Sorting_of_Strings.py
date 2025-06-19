class Solution:
    def caseSort(self,s):
        #code here
        l=list(s)
        l.sort()
        t=""
        i=0
        while (i<len(l)):
            if (l[i].islower()):
                break
            i=i+1
        j=0
        k=0
        while (k<len(s)):
            if (s[k].islower()):
                t=t+l[i]
                i=i+1
            else:
                t=t+l[j]
                j=j+1
            k+=1
        
        return t
  
