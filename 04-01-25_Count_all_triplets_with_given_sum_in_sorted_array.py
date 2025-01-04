def countTriplets(arr, target):
    n=len(arr)
    res=0
    for i in range(n-2):
        left=i+1
        right=n-1

        while left<right:

            sum=arr[i]+arr[left]+arr[right]

            if sum<target:
                left+=1

            elif sum>target:
                right-=1

            else:
                ele1=arr[left]
                ele2=arr[right]
                cnt1=0
                cnt2=0

                while left<=right and arr[left]==ele1:
                    left+=1
                    cnt1+=1

                while left<=right and arr[right]==ele2:
                    right-=1
                    cnt2+=1

                if ele1==ele2:
                    res+=(cnt1 * (cnt1-1))/ 2

                else:
                    res+=(cnt1 * cnt2)

    return res

