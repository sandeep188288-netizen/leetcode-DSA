class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length, ans = 0;
        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++)
            idx[i] = i;
        Arrays.sort(idx, (a, b) -> {
            int x = sum(nums[a]);
            int y = sum(nums[b]);

            if (x != y)
                return x - y;

            return nums[a] - nums[b];
        });
        for (int i = 0; i < n; i++) {
            while (idx[i] != i) {
                int j = idx[i];

                int t = idx[i];
                idx[i] = idx[j];
                idx[j] = t;
                ans++;
            }
        }
        return ans;
    }
    int sum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }
}