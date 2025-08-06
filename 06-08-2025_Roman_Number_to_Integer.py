class Solution:
    def romanToDecimal(self, s): 
        # code here
        t=0
        l=['I','V','X','L','C','D','M']
        v=[1,5,10,50,100,500,1000]
        i=0
        while i<len(s):
            if(i+1<len(s) and l.index(s[i])<l.index(s[i+1])):
                t+=(v[l.index(s[i+1])]-v[l.index(s[i])])
                i+=2
            else:
                t+=v[l.index(s[i])]
                i+=1
        return t
            
