import java.util.*;

class Solution {
    public int checkWays(int[][] pairs) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        // Build graph
        for (int[] p : pairs) {
            graph.putIfAbsent(p[0], new HashSet<>());
            graph.putIfAbsent(p[1], new HashSet<>());
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }

        int root = -1;
        int n = graph.size();

        // Find root
        for (int node : graph.keySet()) {
            if (graph.get(node).size() == n - 1) {
                root = node;
                break;
            }
        }

        if (root == -1)
            return 0;

        int ans = 1;

        for (int node : graph.keySet()) {

            if (node == root)
                continue;

            int parent = -1;
            int parentDegree = Integer.MAX_VALUE;
            int currDegree = graph.get(node).size();

            // Find parent
            for (int nei : graph.get(node)) {

                int deg = graph.get(nei).size();

                if (deg >= currDegree && deg < parentDegree) {
                    parent = nei;
                    parentDegree = deg;
                }
            }

            if (parent == -1)
                return 0;

            // Verify subset
            for (int nei : graph.get(node)) {

                if (nei == parent)
                    continue;

                if (!graph.get(parent).contains(nei))
                    return 0;
            }

            // Multiple answers possible
            if (parentDegree == currDegree)
                ans = 2;
        }

        return ans;
    }
}