class Solution:    
    def ValidCorner(self, mat): 
        row = []
        for i in range(len(mat)):
            if mat[i].count(1) >= 2:
                row.append(i)
        
        for i in range(len(row)):
            for j in range(i + 1, len(row)):
                c = 0
                for k in range(len(mat[0])):
                    if mat[row[i]][k] == 1 and mat[row[j]][k] == 1:
                        c += 1
                        if c == 2:
                            return True
        return False