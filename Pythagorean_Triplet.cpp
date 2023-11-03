class Solution{
public:
	bool checkTriplet(int arr[], int n){
	    int maximum = *max_element(arr, arr + n);
	    vector<bool> squares(maximum + 1, false);
	    for(int i = 0; i < n; i++){
	        squares[arr[i]] = true;
	    }
	    for(int i = 1; i <= maximum; i++){
	        if(squares[i] == false){
	            continue;
	        }
	        for(int j = 1; j <= maximum; j++){
	            if(squares[j] == false or i == j){
	                continue;
	            }
	            int height_square = i*i;
	            int bredth_square = j*j;
	            int hyp_square = height_square + bredth_square;
	            int hyp = sqrt(hyp_square);
	            if(hyp > maximum or hyp*hyp != hyp_square){
	                continue;
	            }
	            if(squares[hyp] == true){
	                return true;
	            }
	        }
	    }
	    return false;
	}
};
