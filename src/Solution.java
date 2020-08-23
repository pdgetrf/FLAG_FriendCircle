class Solution {
    public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int ans = 0;
        int size = M.length;
        BitMask mask = new BitMask();
        for (int i = 0; i < size; i++) {
            if (mask.get(i)) {
                continue;
            }
            ans++;
            helper(M, i, mask);
        }
        return ans;
    }

    private static void helper(int[][] M, int visiting, BitMask mask) {
        for (int i = 0; i < M.length; ++i) {
            if (mask.get(i) || M[visiting][i] == 0) {
                continue;
            }
            mask.setTrue(i);
            helper(M, i, mask);
        }
    }
}
