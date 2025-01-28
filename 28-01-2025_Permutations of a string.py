# Python program to print unique permutation of string using hash set.

# Function genPermutation is used to generate all possible permutation.
def genPermutation(i, s, used, curr, st):
    if i == len(s):
        # Add the permutation to the result set
        st.add("".join(curr))
        return

    for j in range(len(s)):
        if not used[j]:
            # Mark the character as used
            used[j] = True
            curr.append(s[j])
            
            # Recurse with the next character
            genPermutation(i + 1, s, used, curr, st)
            
            # Backtrack and unmark the character
            used[j] = False
            curr.pop()

def findPermutation(s):
    # To track if a character is used
    used = [False] * len(s)
    st = set()
    curr = []

    # Start the recursion
    genPermutation(0, s, used, curr, st)

    # Convert the set to a list
    return list(st)

if __name__ == "__main__":
    s = "ABC"
    res = findPermutation(s)

    # Print the permutations
    for perm in res:
        print(perm, end=" ")