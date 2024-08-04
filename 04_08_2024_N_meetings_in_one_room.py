class Solution:
    
    #Function to find the maximum number of meetings that can
    #be performed in a meeting room.
    def maximumMeetings(self,N,start,end):
        # code here
        meetings = [(end[i], start[i]) for i in range(N)]
        
        # Sort meetings based on end time
        meetings.sort()
        
        # DP array to store the maximum number of meetings up to each meeting
        dp = [1] * N
        
        # Compute the maximum number of meetings
        for i in range(1, N):
            for j in range(i):
                if meetings[j][0] < meetings[i][1]:
                    dp[i] = max(dp[i], dp[j] + 1)
        
        # Return the maximum value in the dp array
        return max(dp)
