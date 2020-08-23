class Solution {
    public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int ans = 0;
        int size = M.length;
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (visited[i]) {
                continue;
            }
            ans++;
            helper(M, i, visited);
        }
        return ans;
    }

    private static void helper(int[][] M, int visiting, boolean[] visited) {
        for (int i = 0; i < M.length; ++i) {
            if (visited[i] || M[visiting][i] == 0) {
                continue;
            }
            visited[i] = true;
            helper(M, i, visited);
        }
    }
}
