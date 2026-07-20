class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        
        k = k % total; 
        
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newIndex = (i * n + j + k) % total;
                int r = newIndex / n;
                int c = newIndex % n;
                res[r][c] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int[] row : res) {
            List<Integer> temp = new ArrayList<>();
            for (int val : row) temp.add(val);
            ans.add(temp);
        }

        return ans;
    }
}