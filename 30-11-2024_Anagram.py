class Solution:
    def areAnagrams(self, s1: str, s2: str) -> bool:
        
        if len(s1) != len(s2):
            return False

 
        list1 = list(s1)
        list2 = list(s2)

        sorted_list1 = sorted(list1)
        sorted_list2 = sorted(list2)

        
        return sorted_list1 == sorted_list2






