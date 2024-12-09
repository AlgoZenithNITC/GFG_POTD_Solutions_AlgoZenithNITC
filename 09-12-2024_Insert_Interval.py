class Solution:

    def insertInterval(self, intervals, newInterval):
        ans = []
        i = 0
        n = len(intervals)

        while i < n and newInterval[0] > intervals[i][1]:
            ans.append(intervals[i])
            i += 1


        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(intervals[i][0], newInterval[0])
            newInterval[1] = max(intervals[i][1], newInterval[1])
            i += 1
        ans.append(newInterval)


        while i < n:
            ans.append(intervals[i])
            i += 1
        return ans
