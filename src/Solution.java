class Solution {
    public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int ans = 0;
        int size = M.length;
        int[] visited = new int[size];
        for (int i = 0; i < size; i++) {
            if (visited[i] == 1) {
                continue;
            }
            ans++;
            helper(M, i, visited);
        }
        return ans;
    }

    private static void helper(int[][] M, int visiting, int[] visited) {
        for (int i = 0; i < M.length; ++i) {
            if (visited[i] == 1 || M[visiting][i] == 0) {
                continue;
            }
            visited[i] = 1;
            helper(M, i, visited);
        }
    }
}
