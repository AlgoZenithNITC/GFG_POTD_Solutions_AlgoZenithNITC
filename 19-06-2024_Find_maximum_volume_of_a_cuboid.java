class Solution {
    public double maxVolume(double perimeter, double area) {
        double h = (perimeter - Math.sqrt(perimeter * perimeter - 24 * area)) / 12;
        double l = (perimeter / 4 - 2 * h);
        return h * h * l;
    }
}

