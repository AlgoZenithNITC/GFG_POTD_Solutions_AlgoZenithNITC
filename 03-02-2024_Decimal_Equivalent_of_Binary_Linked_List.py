class Solution:
    def decimalValue(self, head):
        MOD=10**9+7
        temp = head
        ans = 0
        while(temp != None):
            ans = (ans*2 + temp.data) % MOD
            temp = temp.next
        
        return ans
