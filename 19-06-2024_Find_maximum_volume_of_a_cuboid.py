class Solution:
    def maxVolume(self, perimeter: float, area: float) -> float:
        h = (perimeter - math.sqrt(perimeter * perimeter - 24 * area)) / 12
        l = (perimeter / 4 - 2 * h)
        return h * h * l

