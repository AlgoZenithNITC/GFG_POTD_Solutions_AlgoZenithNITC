def min_repeats(s1: str, s2: str) -> int:
    min_repeats = (len(s2) + len(s1) - 1) // len(s1)
    repeated_s1 = s1 * min_repeats
    if s2 in repeated_s1:
        return min_repeats
    repeated_s1 += s1
    if s2 in repeated_s1:
        return min_repeats + 1
    return -1
