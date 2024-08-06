#User function Template for python3
class Solution:
    def isValid(self, str):
        count=0
        num=list(str.split('.'))
        for i in num:
            if i.isdigit() and 0<=int(i)<=255:
                if len(i)>1 and i[0]=='0':
                    return False
                else:
                    count+=1
                    continue
            else:
                return False
        return True if count==4 else False

