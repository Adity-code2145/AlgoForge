class Solution {
    List<Integer>[] children;
    int[] last;
    int[] newParent;
    int[] ans;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        // Build original tree
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        last = new int[26];
        Arrays.fill(last, -1);

        newParent = new int[n];

        // Find new parent of every node
        dfs1(0, adj, parent, s);

        // Build modified tree
        children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[newParent[i]].add(i);
        }

        // Calculate subtree sizes
        ans = new int[n];
        dfs2(0);

        return ans;
    }

    void dfs1(int node, List<Integer>[] adj, int[] parent, String s) {
        int ch = s.charAt(node) - 'a';

        int previous = last[ch];

        if (previous == -1) {
            newParent[node] = parent[node];
        } else {
            newParent[node] = previous;
        }

        last[ch] = node;

        for (int child : adj[node]) {
            dfs1(child, adj, parent, s);
        }

        last[ch] = previous;
    }

    int dfs2(int node) {
        int size = 1;

        for (int child : children[node]) {
            size += dfs2(child);
        }

        ans[node] = size;

        return size;
    }
}