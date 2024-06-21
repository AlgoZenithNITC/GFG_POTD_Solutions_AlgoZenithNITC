
class Solution:

    def compareFrac(self, str):
        # Initializing variables for numerators and denominators
        a = b = c = d = 0

        # Regular expression to match and extract numerical values from string
        pattern = r"([0-9]+)/([0-9]+), ([0-9]+)/([0-9]+)"
        match = re.search(pattern, str)

        if match:
            a, b, c, d = int(match.group(1)), int(match.group(2)), int(
                match.group(3)), int(match.group(4))

        # Comparing fractions and determining the result
        if a * d > b * c:
            return "{}/{}".format(a, b)
        elif b * c > a * d:
            return "{}/{}".format(c, d)
        else:
            return "equal"
