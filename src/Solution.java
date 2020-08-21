class Solution {
    // Friend Circles
    //
    // Start with a student and start picking a direct friend,
    // move on to that direct friend, try to find their direct friend.
    // Repeat until all students have been checked.
    //
    // Time Complexity : O(n * n), where n is the number of students
    //
    // Space Complexity : O(n), where n is the number of students
    //
    public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }

        int result = 0;
        int studentCount = M.length;
        boolean[] visited = new boolean[studentCount];
        for (int current = 0; current < studentCount; current++) {
            if (!visited[current]) {
                findCircleNum(M, visited, current);
                result++;
            }
        }

        return result;
    }

    private static void findCircleNum(int[][] M, boolean[] visited, int current) {
        visited[current] = true;

        for (int next = 0; next < M.length; next++) {
            if (visited[next]) {
                continue;
            }

            if (M[current][next] == 1) {
                // Use DFS to find direct friends
                findCircleNum(M, visited, next);
            }
        }
    }
}
