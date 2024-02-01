class Solution:
    
    def checkPangram(self,s):
     from string import ascii_lowercase
     alphabet_count = {char: 0 for char in ascii_lowercase}
     for char in s.lower():
        if char in alphabet_count:
            alphabet_count[char] += 1
     return all(value > 0 for value in alphabet_count.values())

