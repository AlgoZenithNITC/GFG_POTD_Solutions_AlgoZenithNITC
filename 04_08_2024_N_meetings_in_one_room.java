class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int N)
    {

        int[][] meetings = new int[N][2];
        
        // Create list of meetings (end, start) pairs
        for (int i = 0; i < N; i++) {
            meetings[i][0] = end[i];
            meetings[i][1] = start[i];
        }
        
        // Sort meetings based on end time
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        
        // DP array to store the maximum number of meetings up to each meeting
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        
        // Compute the maximum number of meetings
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (meetings[j][0] < meetings[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // Return the maximum value in the dp array
        int maxMeetings = 0;
        for (int count : dp) {
            if (count > maxMeetings) {
                maxMeetings = count;
            }
        }
        return maxMeetings;
    }
}
