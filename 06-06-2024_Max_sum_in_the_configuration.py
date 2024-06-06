def max_sum(a,n):
   total_sum = sum(a)
   current_rotation_sum = 0

    # Calculate total sum of array elements and initial rotation sum
   for i in range(n):
        current_rotation_sum += i * a[i]

   max_rotation_sum = current_rotation_sum

    # Calculate rotation sums for all possible rotations and find the maximum
   for i in range(1, n):
        current_rotation_sum = current_rotation_sum - total_sum + n * a[i - 1]
        max_rotation_sum = max(max_rotation_sum, current_rotation_sum)

   return max_rotation_sum
