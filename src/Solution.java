import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int findCircleNum(int[][] M) {
        int size = M.length;
        UnionSet us = new UnionSet(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (M[i][j] == 1) {
                    us.Union(i, j);
                }
            }
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < size; i++) {
            result.add(us.Find(i));
        }
        return result.size();
    }
}
