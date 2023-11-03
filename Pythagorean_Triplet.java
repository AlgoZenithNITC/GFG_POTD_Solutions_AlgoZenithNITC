class Solution {
    boolean checkTriplet(int[] arr, int n) {
        int maximum = Arrays.stream(arr).max().getAsInt();
        boolean[] squares = new boolean[maximum + 1];
        Arrays.fill(squares, false);
        for(int i = 0; i < n; i++){
            squares[arr[i]] = true;
        }
        for(int i = 1; i <= maximum; i++){
            if(!squares[i]){
                continue;
            }
            for(int j = 1; j <= maximum; j++){
                if(!squares[j] || i == j){
                    continue;
                }
                int height_square = i*i;
                int breadth_square = j*j;
                int hyp_square = height_square + breadth_square;
                int hyp = (int)Math.sqrt(hyp_square);
                if(hyp*hyp != hyp_square || hyp > maximum){
                    continue;
                }
                if(squares[hyp]){
                    return true;
                }
            }
        }
        return false;
    }
}
