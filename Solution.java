import java.util.*;

class Solution {
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int LOG = 18;
        int[] dep = new int[n + 1];
        int[][] par = new int[n + 1][LOG];
        Arrays.fill(dep, -1);
        dep[1] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u]) {
                if (dep[v] == -1) {
                    dep[v] = dep[u] + 1;
                    par[v][0] = u;
                    q.add(v);
                }
            }
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                par[i][j] = par[par[i][j - 1]][j - 1];
            }
        }

        int MOD = 1_000_000_007;
        int[] pow2 = new int[n + 2];
        pow2[0] = 1;
        for (int i = 1; i < pow2.length; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int u = queries[i][0], v = queries[i][1];
            int lca = getLCA(u, v, dep, par, LOG);
            int len = dep[u] + dep[v] - 2 * dep[lca];
            if (len == 0) {
                ans[i] = 0;
            } else {
                ans[i] = pow2[len - 1];
            }
        }
        return ans;
    }

    private int getLCA(int u, int v, int[] dep, int[][] par, int LOG) {
        if (dep[u] < dep[v]) {
            int tmp = u; u = v; v = tmp;
        }
        for (int k = LOG - 1; k >= 0; k--) {
            if (dep[u] - (1 << k) >= dep[v]) {
                u = par[u][k];
            }
        }
        if (u == v) return u;
        for (int k = LOG - 1; k >= 0; k--) {
            if (par[u][k] != 0 && par[u][k] != par[v][k]) {
                u = par[u][k];
                v = par[v][k];
            }
        }
        return par[u][0];
    }

    private int powmod(int b, int e, int m) {
        long r = 1, x = b;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * x) % m;
            x = (x * x) % m;
            e >>= 1;
        }
        return (int) r;
    }
}