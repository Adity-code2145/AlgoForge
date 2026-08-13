class Solution {

    class Node {
        int leftMax;
        int rightMax;
        int max;

        Node(int leftMax, int rightMax, int max) {
            this.leftMax = leftMax;
            this.rightMax = rightMax;
            this.max = max;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters,
                                  int[] queryIndices) {

        arr = s.toCharArray();
        int n = arr.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            // Update character
            arr[index] = ch;

            // Update segment tree
            update(1, 0, n - 1, index);

            // Root contains the answer
            ans[i] = tree[1].max;
        }

        return ans;
    }

    // Build segment tree
    void build(int node, int start, int end) {

        if (start == end) {
            tree[node] = new Node(1, 1, 1);
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        merge(node, start, end);
    }

    // Update one index
    void update(int node, int start, int end, int index) {

        if (start == end) {
            tree[node] = new Node(1, 1, 1);
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, end, index);
        }

        merge(node, start, end);
    }

    // Merge left and right children
    void merge(int node, int start, int end) {

        int mid = (start + end) / 2;

        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];

        Node curr = new Node(
            left.leftMax,
            right.rightMax,
            Math.max(left.max, right.max)
        );

        // Can combine left suffix + right prefix
        if (arr[mid] == arr[mid + 1]) {

            // If entire left part has same character
            if (left.leftMax == mid - start + 1) {
                curr.leftMax = left.leftMax + right.leftMax;
            }

            // If entire right part has same character
            if (right.rightMax == end - mid) {
                curr.rightMax = left.rightMax + right.rightMax;
            }

            // Longest substring crossing the middle
            curr.max = Math.max(
                curr.max,
                left.rightMax + right.leftMax
            );
        }

        tree[node] = curr;
    }
}