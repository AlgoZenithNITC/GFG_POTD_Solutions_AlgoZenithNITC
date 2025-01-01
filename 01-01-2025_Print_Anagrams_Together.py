class Solution:
    def anagrams(self, arr):
        list=[]
        #code here
        for i in range(len(arr)):
            check=0
            for j in range(len(list)):
                if (''.join(sorted(arr[i]))==''.join(sorted(list[j][0]))):
                    list[j].append(arr[i])
                    check=1
                    break
            if (check==0):
                pl=[arr[i]]
                list.append(pl)
        list.sort()
        return list
