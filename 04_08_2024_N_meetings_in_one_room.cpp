class Solution
{
    public:
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    int maxMeetings(int start[], int end[], int N) {
        vector<pair<int, int>> meetings;
        for (int i = 0; i < N; i++) {
            meetings.push_back(make_pair(end[i], start[i]));
        }
        sort(meetings.begin(), meetings.end());
    
        vector<int> dp(N, 1);
    
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (meetings[j].first < meetings[i].second) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
    
        return *max_element(dp.begin(), dp.end());
    }
};
