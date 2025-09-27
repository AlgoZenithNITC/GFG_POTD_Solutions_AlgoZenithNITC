def kBitFlips(self, arr, k):
    n=len(arr)
    flips=0
    parity=0
    q=deque()
    for i in range(n):
        if q and q[0]==i-k:
            q.popleft()
            parity^=1
        if arr[i]^parity==0:
            if i+k>n:
                return -1
            q.append(i)
            flips+=1
            parity^=1
    return flips
