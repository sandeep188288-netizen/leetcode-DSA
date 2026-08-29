class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> nums[a] - nums[b]);
        int[] ans = new int[n];
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && nums[idx[j + 1]] - nums[idx[j]] <= limit) {
                j++;
            }

            int[] positions = new int[j - i + 1];
            for (int k = i; k <= j; k++) {
                positions[k - i] = idx[k];
            }

            Arrays.sort(positions);
            for (int k = 0; k < positions.length; k++) {
                ans[positions[k]] = nums[idx[i + k]];
            }

            i = j + 1;
        }
        return ans;
    }
}