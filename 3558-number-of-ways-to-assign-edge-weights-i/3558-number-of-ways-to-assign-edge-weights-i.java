class Solution {
    static final int MOD = 1_000_000_007;
    List<Integer>[] g;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        g = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int depth = dfs(1, 0);

        long ans = 1;
        while (--depth > 0) {
            ans = (ans * 2) % MOD;
        }

        return (int) ans;
    }

    int dfs(int node, int parent) {
        int depth = 0;

        for (int next : g[node]) {
            if (next != parent) {
                depth = Math.max(depth, 1 + dfs(next, node));
            }
        }

        return depth;
    }
}