class Solution {
  public:
    int swapNibbles(int n) {
        return ((n & 0xF0)>>4)|((n & 0x0F)<<4);
    }
};
