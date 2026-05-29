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
class Pair {
    TreeNode node;
    int hd;     // horizontal distance
    int level;  // row

    Pair(TreeNode node, int hd, int level){
        this.node = node;
        this.hd = hd;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // hd -> (level -> minHeap of values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            Pair front = q.remove();

            TreeNode node = front.node;
            int hd = front.hd;
            int level = front.level;

            map.putIfAbsent(hd, new TreeMap<>());
            map.get(hd).putIfAbsent(level, new PriorityQueue<>());
            map.get(hd).get(level).add(node.val);

            if(node.left != null){
                q.add(new Pair(node.left, hd - 1, level + 1));
            }

            if(node.right != null){
                q.add(new Pair(node.right, hd + 1, level + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()){
            List<Integer> list = new ArrayList<>();

            for(PriorityQueue<Integer> pq : levels.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }

        return ans;
    }
}