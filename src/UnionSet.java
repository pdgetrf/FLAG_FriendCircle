class UnionSet {
    private int[] parents;
    private int[] ranks;

    public UnionSet(int n) {
        parents = new int[n + 1];
        ranks = new int[n + 1];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    public int Find(int id) {
        if (id != parents[id])
            parents[id] = Find(parents[id]);
        return parents[id];
    }

    public void Union(int e1, int e2) {
        int p1 = Find(e1);
        int p2 = Find(e2);
        if (p1 == p2) {
            return;
        }

        int r1 = ranks[p1];
        int r2 = ranks[p2];
        if (r1 > r2) {
            parents[p2] = p1;
        } else if (r2 > r1) {
            parents[p1] = p2;
        } else {
            parents[p1] = p2;
            ranks[p2]++;
        }
    }
}