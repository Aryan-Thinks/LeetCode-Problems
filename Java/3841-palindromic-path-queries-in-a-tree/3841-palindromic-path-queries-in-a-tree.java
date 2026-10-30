// https://leetcode.com/problems/palindromic-path-queries-in-a-tree


import java.util.*;

class Solution {

    private int LOG, timer;
    private int[] tin, tout;
    private int[][] up;
    private List<Integer>[] adj;
    private char[] s;
    private Fenwick fenwick;

    // Fenwick Tree using XOR
    class Fenwick {

        int n;
        int[] tree;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        // XOR update
        void update(int i, int val) {
            while (i <= n) {
                tree[i] ^= val;
                i += i & -i;
            }
        }

        // Prefix XOR query
        int query(int i) {
            int res = 0;

            while (i > 0) {
                res ^= tree[i];
                i -= i & -i;
            }

            return res;
        }
    }

    // Convert character into a 26-bit mask
    private int getMask(int u) {
        return 1 << (s[u] - 'a');
    }

    // DFS for Euler Tour and Binary Lifting
    private void dfs(int u, int parent) {

        tin[u] = ++timer;
        up[0][u] = parent;

        // Build binary lifting table
        for (int j = 1; j < LOG; j++) {
            up[j][u] = up[j - 1][up[j - 1][u]];
        }

        for (int v : adj[u]) {
            if (v == parent) {
                continue;
            }

            dfs(v, u);
        }

        tout[u] = timer;
    }

    // Check whether u is an ancestor of v
    private boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[v] <= tout[u];
    }

    // Find Lowest Common Ancestor
    private int lca(int u, int v) {

        if (isAncestor(u, v)) {
            return u;
        }

        if (isAncestor(v, u)) {
            return v;
        }

        for (int j = LOG - 1; j >= 0; j--) {

            int ancestor = up[j][u];

            if (!isAncestor(ancestor, v)) {
                u = ancestor;
            }
        }

        return up[0][u];
    }

    public List<Boolean> palindromePath(
            int n,
            int[][] edges,
            String s,
            String[] queries) {

        // Convert input String to character array
        this.s = s.toCharArray();

        // Build adjacency list
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        // Calculate binary lifting levels
        LOG = 1;

        while ((1 << LOG) <= n) {
            LOG++;
        }

        tin = new int[n];
        tout = new int[n];
        up = new int[LOG][n];

        timer = 0;

        // Root the tree at node 0
        dfs(0, 0);

        /*
         * Difference Euler Tour:
         * Add character mask at tin[u].
         * Remove character mask at tout[u] + 1.
         */
        fenwick = new Fenwick(n + 1);

        for (int u = 0; u < n; u++) {

            int mask = getMask(u);

            fenwick.update(tin[u], mask);
            fenwick.update(tout[u] + 1, mask);
        }

        List<Boolean> answer = new ArrayList<>();

        // Process queries
        for (String query : queries) {

            String[] parts = query.trim().split("\\s+");

            if (parts[0].equals("update")) {

                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                // Old and new character masks
                int oldMask = getMask(u);
                int newMask = 1 << (c - 'a');

                // Calculate XOR difference
                int delta = oldMask ^ newMask;

                // Update Fenwick Tree
                fenwick.update(tin[u], delta);
                fenwick.update(tout[u] + 1, delta);

                // Update class-level character array
                this.s[u] = c;

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                // Find LCA
                int w = lca(u, v);

                /*
                 * Path XOR:
                 * rootToU XOR rootToV XOR character[LCA]
                 */
                int mask =
                        fenwick.query(tin[u]) ^
                        fenwick.query(tin[v]) ^
                        getMask(w);

                // At most one character can have odd frequency
                answer.add(Integer.bitCount(mask) <= 1);
            }
        }

        return answer;
    }
}
