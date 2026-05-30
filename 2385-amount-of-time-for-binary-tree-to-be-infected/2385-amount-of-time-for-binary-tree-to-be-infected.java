/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair{
        TreeNode node;
        int dist;
        Pair(TreeNode node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public int amountOfTime(TreeNode root, int start) {

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode startNode = dfs(root, start, parent);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startNode, 0));

        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(startNode);

        int time = 0;

        while(!q.isEmpty()){
            Pair front = q.poll();
            TreeNode node = front.node;
            int dist = front.dist;

            time = Math.max(time, dist);

            // left
            if(node.left != null && !visited.contains(node.left)){
                visited.add(node.left);
                q.add(new Pair(node.left, dist + 1));
            }

            // right
            if(node.right != null && !visited.contains(node.right)){
                visited.add(node.right);
                q.add(new Pair(node.right, dist + 1));
            }

            // parent
            if(parent.containsKey(node) && !visited.contains(parent.get(node))){
                visited.add(parent.get(node));
                q.add(new Pair(parent.get(node), dist + 1));
            }
        }

        return time;
    }

    private TreeNode dfs(TreeNode root, int start, HashMap<TreeNode, TreeNode> parent){
        if(root == null) return null;

        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right, root);

        TreeNode left = dfs(root.left, start, parent);
        TreeNode right = dfs(root.right, start, parent);

        if(root.val == start) return root;
        if(left != null) return left;
        if(right != null) return right;

        return null;
    }
}