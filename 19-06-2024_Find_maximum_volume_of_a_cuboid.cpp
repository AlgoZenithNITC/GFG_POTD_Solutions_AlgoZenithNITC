class Solution {
  public:
    double maxVolume(double perimeter, double area) {
        // code here
        double h=(perimeter-sqrt(perimeter*perimeter-24*area))/12;
        double l=(perimeter/4-2*h);
        return h*h*l;
    }  
};
