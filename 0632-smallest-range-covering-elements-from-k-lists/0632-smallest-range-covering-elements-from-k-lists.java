class Solution {
    class Triplet implements Comparable<Triplet> {
        int ele, row, col;

        Triplet(int ele, int row, int col) {
            this.ele = ele;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Triplet t) {
            return Integer.compare(this.ele, t.ele);
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();

        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            max = Math.max(max, val);
            min = Math.min(min, val);
            pq.add(new Triplet(val, i, 0));
        }

        int a = min, b = max;

        while (true) {
            Triplet top = pq.remove();

            int ele = top.ele;
            int row = top.row;
            int col = top.col;

            if (max - ele < b - a) {
                a = ele;
                b = max;
            }

            if (col == nums.get(row).size() - 1) break;

            int next = nums.get(row).get(col + 1);
            max = Math.max(max, next);

            pq.add(new Triplet(next, row, col + 1));
        }

        return new int[]{a, b};
    }
}