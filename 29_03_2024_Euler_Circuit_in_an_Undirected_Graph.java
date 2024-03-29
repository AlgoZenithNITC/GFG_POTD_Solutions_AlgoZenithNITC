import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isEularCircuitExist(int v, List<Integer>[] adj) {
        List<Integer> deg = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            deg.add(0);
        }
        for (int i = 0; i < v; i++) {
            for (int it : adj[i]) {
                deg.set(it, deg.get(it) + 1);
            }
        }
        for (int i = 0; i < v; i++) {
            if (deg.get(i) % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}

