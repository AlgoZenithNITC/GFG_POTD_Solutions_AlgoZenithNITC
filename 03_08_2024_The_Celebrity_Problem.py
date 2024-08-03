class Solution:
    
    #Function to find if there is a celebrity in the party or not.
    def celebrity(self, Mat, N):
        # code here 
        indegree = [0] * N
        outdegree = [0] * N

        # Query for all edges
        for i in range(N):
            for j in range(N):
                x = Mat[i][j]

                # Set the degrees
                outdegree[i] += x
                indegree[j] += x

        # Find a person with indegree N-1 and outdegree 0
        for i in range(N):
            if indegree[i] == N - 1 and outdegree[i] == 0:
                return i

        return -1
